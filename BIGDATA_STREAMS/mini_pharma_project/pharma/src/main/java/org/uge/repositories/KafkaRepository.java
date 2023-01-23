package org.uge.repositories;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.uge.models.Person;
import org.uge.utils.Consummer;
import org.uge.utils.Producer;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class KafkaRepository {

    private final DrugRepositoryPSQL drugRepositoryPSQL;
    private final PharmaRepositoryPSQL pharmaRepositoryPSQL;

    public KafkaRepository() {
        this.drugRepositoryPSQL = new DrugRepositoryPSQL();
        this.pharmaRepositoryPSQL = new PharmaRepositoryPSQL();
    }

    public void sendMessage(Producer producer) throws SQLException, JsonProcessingException, ExecutionException, InterruptedException {
        var user = new Faker();
        var drug = drugRepositoryPSQL.getRandom();
        var pharma = pharmaRepositoryPSQL.getRandom();

        var objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        producer.send("simpleTopic", objectMapper.writeValueAsString(new Person(
            user.name().firstName(),
            user.name().lastName(),
            drug.cip(),
            drug.price(),
            pharma.id()
        )));
    }

    public void listen(Consummer consummer) {
        consummer.subscribe();
    }




}
