package org.uge.utils.avro;

import com.twitter.bijection.Injection;
import com.twitter.bijection.avro.GenericAvroCodecs;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.uge.models.Person;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class MultiAvroConsumerProducer {

    private final KafkaConsumer<String, byte[]> consumer;

    public MultiAvroConsumerProducer() {

        String bootstrapServers = "127.0.0.1:9092,127.0.0.1:9093,127.0.0.1:9094";
        String groupId = "groupAvro";
        var topic = "topic3Rep";

        var properties = new Properties();
        // create consumer configs
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        consumer = new KafkaConsumer<>(properties);

        var partition1 = new TopicPartition(topic, 0);
        var partition2 = new TopicPartition(topic, 1);
        var partition3 = new TopicPartition(topic, 2);

        consumer.assign(Arrays.asList(
            partition1,
            partition2,
            partition3
        ));
        /*consumer.seek(partition1, 0L);
        consumer.seek(partition2, 0L);
        consumer.seek(partition3, 0L);*/

        //consumer.subscribe(Arrays.asList(topic));
    }

    public void subscribe() throws URISyntaxException, IOException, ExecutionException, InterruptedException {
        Duration oneSecond = Duration.ofSeconds(1);
        boolean running = true;

        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(Person.openSchema());
        Injection<GenericRecord, byte[]> recordInjection = GenericAvroCodecs.toBinary(schema);
        var innerProducer = new InnerProducer();
        try {
            while (running) {
                ConsumerRecords<String, byte[]> records = consumer.poll(oneSecond);
                for (ConsumerRecord<String, byte[]> record : records) {
                    GenericRecord genericRecord = recordInjection.invert(record.value()).get();
                    System.out.println("Key: " + record.key() + ", Value: " + record.value());
                    System.out.println("Partition: " + record.partition() + ", Offset:" + record.offset());
                    var firstName =genericRecord.get("firstName");
                    var lastName = genericRecord.get("lastName");
                    var cip = genericRecord.get("cip");
                    var price = genericRecord.get("price");
                    var idPharma = genericRecord.get("idPharma");
                    System.out.println(
                        "{" +
                            "firstname: "+  firstName+ ", " +
                            "lastname: " + lastName + ", " +
                            "cip: " + cip + ", " +
                            "price: " + price + ", " +
                            "idPharma: " + idPharma
                    );
                    innerProducer.send("top2",
                        String.valueOf(firstName),
                        String.valueOf(lastName),
                        Long.valueOf(cip.toString()),
                        Double.valueOf(price.toString()),
                        Long.valueOf(idPharma.toString())
                    );
                }
                consumer.commitAsync();
            }
        } finally {
            consumer.close();
            innerProducer.close();
        }

    }

    private class InnerProducer {
        private final KafkaProducer<String, byte[]> producer;

        private final Properties properties;

        public InnerProducer() {
            this.properties = new Properties();
            properties.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
            properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
            this.producer = new KafkaProducer<>(properties);
        }

        public void send(String topic, String firstName, String lastName, Long cip, Double price, Long idPharma) throws ExecutionException, InterruptedException, URISyntaxException, IOException {

            Schema.Parser parser = new Schema.Parser();
            Schema schema = parser.parse(Person.openSchema());
            Injection<GenericRecord, byte[]> recordInjection = GenericAvroCodecs.toBinary(schema);
            GenericData.Record avroRecord = new GenericData.Record(schema);
            avroRecord.put("firstName", firstName);
            avroRecord.put("lastName", lastName);
            avroRecord.put("cip", cip);
            avroRecord.put("price", price);
            avroRecord.put("idPharma", idPharma);
            byte[] bytes = recordInjection.apply(avroRecord);
            var record = new ProducerRecord<String, byte[]>(topic, bytes);
            producer.send(record, new ExampleCallback());
            producer.flush(); // because sometimes it only send 2
        }

        public void close() {
            producer.close();
        }

        private class ExampleCallback implements Callback {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e != null) {
                    e.printStackTrace();
                }
            }
        }
    }
}
