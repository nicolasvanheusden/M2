package org.uge;


import org.uge.repositories.KafkaRepository;
import org.uge.utils.Consummer;
import org.uge.utils.avro.AvroConsumer;
import org.uge.utils.avro.MultiAvroConsumer;
import org.uge.utils.avro.MultiAvroConsumerProducer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;


public class ConsumerMain {

    public static void main(String[] args) throws URISyntaxException, IOException, ExecutionException, InterruptedException {
        var kafkaRepository = new KafkaRepository();
        var consumer = new MultiAvroConsumerProducer();
        kafkaRepository.listen(consumer);
    }
}
