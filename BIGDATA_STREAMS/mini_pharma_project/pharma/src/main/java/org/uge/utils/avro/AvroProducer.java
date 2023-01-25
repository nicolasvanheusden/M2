package org.uge.utils.avro;

import org.apache.avro.Schema;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class AvroProducer {
    private final KafkaProducer<String, byte[]> producer;

    private final Properties properties;

    public AvroProducer() {
        this.properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        this.producer = new KafkaProducer<>(properties);
    }

    public void send(String topic, byte[] message) throws ExecutionException, InterruptedException {
        var record = new ProducerRecord<String, byte[]>(topic, message);
        producer.send(record, new ExampleCallback());

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
