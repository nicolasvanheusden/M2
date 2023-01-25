package org.uge.utils.avro;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class AvroConsumer {


    private final KafkaConsumer<String, String> consumer;

    public AvroConsumer() {

        String bootstrapServers = "127.0.0.1:9092";
        String groupId = "groupAvro";

        var properties = new Properties();
        // create consumer configs
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("avroTopic"));
    }

    public void subscribe() {
        Duration oneSecond = Duration.ofSeconds(1);
        boolean running = true;

        while (running) {
            ConsumerRecords<String, String> records = consumer.poll(oneSecond);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Key: " + record.key() + ", Value: " + record.value());
                System.out.println("Partition: " + record.partition() + ", Offset:" + record.offset());
            }
        }
        consumer.close();
    }
}
