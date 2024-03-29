package org.uge.utils.avro;

import com.twitter.bijection.Injection;
import com.twitter.bijection.avro.GenericAvroCodecs;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.uge.models.Person;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class MultiAvroConsumer {
    private final KafkaConsumer<String, byte[]> consumer;

    public MultiAvroConsumer() {

        String bootstrapServers = "127.0.0.1:9092,127.0.0.1:9093,127.0.0.1:9094";
        String groupId = "groupAvro";
        var topic = "topic3Rep";

        var properties = new Properties();
        // create consumer configs
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumer = new KafkaConsumer<>(properties);

        var partition1 = new TopicPartition(topic, 0);
        var partition2 = new TopicPartition(topic, 1);
        var partition3 = new TopicPartition(topic, 2);

        consumer.assign(Arrays.asList(
            partition1,
            partition2,
            partition3
        ));
        consumer.seek(partition1, 0L);
        consumer.seek(partition2, 0L);
        consumer.seek(partition3, 0L);

        //consumer.subscribe(Arrays.asList(topic));
    }

    public void subscribe() throws URISyntaxException, IOException {
        Duration oneSecond = Duration.ofSeconds(1);
        boolean running = true;

        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(Person.openSchema());
        Injection<GenericRecord, byte[]> recordInjection = GenericAvroCodecs.toBinary(schema);
        try {
            while (running) {
                ConsumerRecords<String, byte[]> records = consumer.poll(oneSecond);
                for (ConsumerRecord<String, byte[]> record : records) {
                    GenericRecord genericRecord = recordInjection.invert(record.value()).get();
                    System.out.println("Key: " + record.key() + ", Value: " + record.value());
                    System.out.println("Partition: " + record.partition() + ", Offset:" + record.offset());
                    System.out.println(
                        "{" +
                            "firstname: "+ genericRecord.get("firstName") + ", " +
                            "lastname: " + genericRecord.get("lastName") + ", " +
                            "cip: " + genericRecord.get("cip") + ", " +
                            "price: " + genericRecord.get("price") + ", " +
                            "idPharma: " + genericRecord.get("idPharma")
                    );
                }
                consumer.commitAsync();
            }
        } finally {
            consumer.close();
        }


    }
}
