package org.uge.repositories;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.twitter.bijection.Injection;
import com.twitter.bijection.avro.GenericAvroCodecs;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.uge.models.Person;
import org.uge.utils.Consummer;
import org.uge.utils.Producer;
import org.uge.utils.avro.AvroConsumer;
import org.uge.utils.avro.AvroProducer;
import org.uge.utils.avro.MultiAvroConsumer;
import org.uge.utils.avro.MultiAvroProducer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class KafkaRepository {

    private final DrugRepositoryPSQL drugRepositoryPSQL;
    private final PharmaRepositoryPSQL pharmaRepositoryPSQL;

    public KafkaRepository() {
        this.drugRepositoryPSQL = new DrugRepositoryPSQL();
        this.pharmaRepositoryPSQL = new PharmaRepositoryPSQL();
    }

    public void sendMessage(Producer producer) throws SQLException, JsonProcessingException, ExecutionException, InterruptedException {
        var user = new Faker();
        var drug = drugRepositoryPSQL.getRandom();
        var pharma = pharmaRepositoryPSQL.getRandom();

        var objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        producer.send("simpleTopic", objectMapper.writeValueAsString(new Person(
            user.name().firstName(),
            user.name().lastName(),
            drug.cip(),
            drug.price(),
            pharma.id()
        )));
    }



    public void sendMessage(AvroProducer producer) throws SQLException, ExecutionException, InterruptedException, URISyntaxException, IOException {
        var user = new Faker();
        var drug = drugRepositoryPSQL.getRandom();
        var pharma = pharmaRepositoryPSQL.getRandom();

        var person = new Person(
            user.name().firstName(),
            user.name().lastName(),
            drug.cip(),
            drug.price(),
            pharma.id()
        );

        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(Person.openSchema());
        Injection<GenericRecord, byte[]> recordInjection = GenericAvroCodecs.toBinary(schema);

        GenericData.Record avroRecord = new GenericData.Record(schema);
        avroRecord.put("firstName", person.firstName());
        avroRecord.put("lastName", person.lastName());
        avroRecord.put("cip", person.cip());
        avroRecord.put("price", person.price());
        avroRecord.put("idPharma", person.idPharma());

        byte[] bytes = recordInjection.apply(avroRecord);

        producer.send("avroTopic", bytes);
    }

    public void sendMessage(MultiAvroProducer producer) throws SQLException, ExecutionException, InterruptedException, URISyntaxException, IOException {
        var user = new Faker();
        var drug = drugRepositoryPSQL.getRandom();
        var pharma = pharmaRepositoryPSQL.getRandom();

        var person = new Person(
            user.name().firstName(),
            user.name().lastName(),
            drug.cip(),
            drug.price(),
            pharma.id()
        );

        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(Person.openSchema());
        Injection<GenericRecord, byte[]> recordInjection = GenericAvroCodecs.toBinary(schema);

        GenericData.Record avroRecord = new GenericData.Record(schema);
        avroRecord.put("firstName", person.firstName());
        avroRecord.put("lastName", person.lastName());
        avroRecord.put("cip", person.cip());
        avroRecord.put("price", person.price());
        avroRecord.put("idPharma", person.idPharma());

        byte[] bytes = recordInjection.apply(avroRecord);

        producer.send("topic3Rep", bytes);
    }




    public void listen(Consummer consummer) {
        consummer.subscribe();
    }
    public void listen(AvroConsumer consummer) throws URISyntaxException, IOException {
        consummer.subscribe();
    }
    public void listen(MultiAvroConsumer consumer) throws URISyntaxException, IOException {
        consumer.subscribe();
    }




}
