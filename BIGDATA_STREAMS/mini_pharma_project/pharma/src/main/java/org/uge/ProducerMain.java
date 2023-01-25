package org.uge;

import org.uge.repositories.KafkaRepository;
import org.uge.utils.avro.MultiAvroProducer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class ProducerMain {
    public static void main(String[] args) throws SQLException, ExecutionException, IOException, InterruptedException, URISyntaxException {
        var kafkaRepository = new KafkaRepository();
        var producer = new MultiAvroProducer();
        kafkaRepository.sendMessage(producer);
        kafkaRepository.sendMessage(producer);
        kafkaRepository.sendMessage(producer);
    }
}
