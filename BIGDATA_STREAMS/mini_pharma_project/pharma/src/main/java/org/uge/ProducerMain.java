package org.uge;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.uge.repositories.KafkaRepository;
import org.uge.utils.Producer;
import org.uge.utils.avro.AvroProducer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class ProducerMain {
    public static void main(String[] args) throws SQLException, ExecutionException, IOException, InterruptedException, URISyntaxException {
        var kafkaRepository = new KafkaRepository();
        var producer = new AvroProducer();
        kafkaRepository.sendMessage(producer);
        kafkaRepository.sendMessage(producer);
        kafkaRepository.sendMessage(producer);
    }
}
