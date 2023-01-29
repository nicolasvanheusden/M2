package org.uge.utils.stream;

import com.twitter.bijection.Injection;
import com.twitter.bijection.avro.GenericAvroCodecs;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.Record;
import org.uge.models.Person;
import org.uge.utils.Constants;
import org.uge.utils.avro.AvroProducer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public class AnonymProcessor implements Processor<Void, byte[], Void, byte[]> {
    
    private final AvroProducer producer = new AvroProducer();

    @Override
    public void process(Record<Void, byte[]> record) {
        Schema.Parser parser = new Schema.Parser();
        Schema schema = null;
        try {
            schema = parser.parse(Person.openSchema());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Injection<GenericRecord, byte[]> recordInjection = GenericAvroCodecs.toBinary(schema);
        GenericRecord genericRecord = recordInjection.invert(record.value()).get();
        
        var firstName =genericRecord.get("firstName");
        var lastName = genericRecord.get("lastName");
        var cip = genericRecord.get("cip");
        var price = genericRecord.get("price");
        var idPharma = genericRecord.get("idPharma");

        try {
            sendAnonymUser(
                firstName.toString(),
                lastName.toString(),
                (Long) cip,
                (Double) price,
                (Long) idPharma,
                schema,
                "anonym"
            );
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void sendAnonymUser(
        String firstName,
        String lastName,
        long cip,
        double price,
        long idPharma,
        Schema schema,
        String topic
    ) throws URISyntaxException, IOException, ExecutionException, InterruptedException {
        var person = new Person(
            firstName.replace(
                firstName.subSequence(firstName.length() / 2, firstName.length()-2),
                "*".repeat(firstName.length()-firstName.length() / 2)
            ),
            lastName.replace(
                lastName.subSequence(lastName.length() / 2, lastName.length()-2),
                "*".repeat(lastName.length()-lastName.length() / 2)
            ),
            cip,
            price,
            idPharma
        );
        System.out.println(person);
        Injection<GenericRecord, byte[]> recordInjection = GenericAvroCodecs.toBinary(schema);

        GenericData.Record avroRecord = new GenericData.Record(schema);
        avroRecord.put("firstName", person.firstName());
        avroRecord.put("lastName", person.lastName());
        avroRecord.put("cip", person.cip());
        avroRecord.put("price", person.price());
        avroRecord.put("idPharma", person.idPharma());

        byte[] bytes = recordInjection.apply(avroRecord);


        producer.send(Constants.TOPIC_ANONYM, bytes);
    }
}
