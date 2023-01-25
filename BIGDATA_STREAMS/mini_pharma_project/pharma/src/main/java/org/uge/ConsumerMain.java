package org.uge;


import org.uge.repositories.KafkaRepository;
import org.uge.utils.Consummer;
import org.uge.utils.avro.AvroConsumer;


public class ConsumerMain {

    public static void main(String[] args) {
        var kafkaRepository = new KafkaRepository();
        var consumer = new AvroConsumer();
        kafkaRepository.listen(consumer);
    }
}
