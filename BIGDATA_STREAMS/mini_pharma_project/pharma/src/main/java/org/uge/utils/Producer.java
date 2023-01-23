package org.uge.utils;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer {
    private final KafkaProducer<String, String> producer;

    private final Properties properties;

    public Producer() {
        this.properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.producer = new KafkaProducer<>(properties);
    }

    public void send(String topic, String message) throws ExecutionException, InterruptedException {
        var record = new ProducerRecord<String, String>(topic, message);
        producer.send(record);

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
