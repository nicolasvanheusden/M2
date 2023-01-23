package org.uge;

import org.uge.repositories.KafkaRepository;
import org.uge.utils.Consummer;


public class ConsumerMain {

    public static void main(String[] args) {
        var kafkaRepository = new KafkaRepository();
        var consumer = new Consummer();
        kafkaRepository.listen(consumer);
    }

}

