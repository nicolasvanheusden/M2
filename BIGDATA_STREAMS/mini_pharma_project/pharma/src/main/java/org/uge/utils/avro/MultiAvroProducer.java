package org.uge.utils.avro;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class MultiAvroProducer {
    private final KafkaProducer<String, byte[]> producer;

    private final Properties properties;

    public MultiAvroProducer() {
        this.properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        this.producer = new KafkaProducer<>(properties);
    }

    public void send(String topic, byte[] message) throws ExecutionException, InterruptedException {
        var record = new ProducerRecord<String, byte[]>(topic, message);
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
