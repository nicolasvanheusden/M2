package org.uge;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.uge.repositories.KafkaRepository;
import org.uge.utils.Producer;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class ProducerMain {
    public static void main(String[] args) throws SQLException, ExecutionException, JsonProcessingException, InterruptedException {
        var kafkaRepository = new KafkaRepository();
        var producer = new Producer();
        kafkaRepository.sendMessage(producer);
        kafkaRepository.sendMessage(producer);
        kafkaRepository.sendMessage(producer);
    }
}
