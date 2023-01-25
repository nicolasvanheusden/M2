package org.uge;


import org.uge.repositories.KafkaRepository;
import org.uge.utils.Consummer;
import org.uge.utils.avro.AvroConsumer;

import java.io.IOException;
import java.net.URISyntaxException;


public class ConsumerMain {

    public static void main(String[] args) throws URISyntaxException, IOException {
        var kafkaRepository = new KafkaRepository();
        var consumer = new AvroConsumer();
        kafkaRepository.listen(consumer);
    }
}
