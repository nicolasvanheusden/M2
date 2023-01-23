package org.uge.utils;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Consummer {

    private final Properties properties;
    private final KafkaConsumer<String, String> consumer;

    public Consummer() {
        this.properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "group1");
        consumer = new KafkaConsumer<>(properties);

    }

    public void subscribe() {
        Duration oneSecond = Duration.ofSeconds(1);
        boolean running = true;
        while (running) {
            consumer.subscribe((Arrays.asList("simpleTopic")));
            ConsumerRecords<String, String> records = consumer.poll(oneSecond);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record);
            }
            System.out.println(records.isEmpty());
        }
        consumer.close();
    }
}
