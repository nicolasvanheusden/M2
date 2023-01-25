package org.uge.utils.avro;

import com.twitter.bijection.Injection;
import com.twitter.bijection.avro.GenericAvroCodecs;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.uge.models.Person;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerLoop implements Runnable {
    private final KafkaConsumer<String, byte[]> consumer;
    private final List<String> topics;
    private final int id;
    private final AtomicInteger transactionId = new AtomicInteger();
    private final DataAnalyzing analyzing;

    public ConsumerLoop(int id,
                        String groupId,
                        List<String> topics,
                        DataAnalyzing analyzing) {
        this.id = id;
        this.topics = topics;
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
        props.put("group.id", groupId);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        this.consumer = new KafkaConsumer<>(props);
        this.analyzing = analyzing;
    }

    @Override
    public void run() {
        try {
            consumer.subscribe(topics);

            Duration oneSecond = Duration.ofSeconds(1);
            boolean running = true;

            Schema.Parser parser = new Schema.Parser();
            Schema schema = parser.parse(Person.openSchema());
            Injection<GenericRecord, byte[]> recordInjection = GenericAvroCodecs.toBinary(schema);
            while (running) {
                ConsumerRecords<String, byte[]> records = consumer.poll(oneSecond);
                for (ConsumerRecord<String, byte[]> record : records) {
                    GenericRecord genericRecord = recordInjection.invert(record.value()).get();
                    /*System.out.println("Key: " + record.key() + ", Value: " + record.value());
                    System.out.println("Partition: " + record.partition() + ", Offset:" + record.offset());
                    System.out.println(
                        "{" +
                            "firstname: "+ genericRecord.get("firstName") + ", " +
                            "lastname: " + genericRecord.get("lastName") + ", " +
                            "cip: " + genericRecord.get("cip") + ", " +
                            "price: " + genericRecord.get("price") + ", " +
                            "idPharma: " + genericRecord.get("idPharma")
                    );*/
                    analyzing.addDrug(genericRecord.get("cip").toString());
                    analyzing.printDrugSold();
                }
                consumer.commitAsync();
            }

        } catch (WakeupException e) {
            // ignore for shutdown
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            consumer.close();
        }
    }
    public void shutdown() {
        consumer.wakeup();
    }
}