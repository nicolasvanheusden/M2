package org.uge.repositories;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.twitter.bijection.Injection;
import com.twitter.bijection.avro.GenericAvroCodecs;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.uge.models.Person;
import org.uge.utils.Consummer;
import org.uge.utils.Producer;
import org.uge.utils.avro.AvroConsumer;
import org.uge.utils.avro.AvroProducer;

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

    private static final String USER_SCHEMA = "{"
        + "\"type\":\"record\","
        + "\"name\":\"myrecord\","
        + "\"fields\":["
        + "  { \"name\":\"str1\", \"type\":\"string\" },"
        + "  { \"name\":\"str2\", \"type\":\"string\" },"
        + "  { \"name\":\"int1\", \"type\":\"int\" }"
        + "]}";

    public void sendMessage(AvroProducer producer) throws SQLException, ExecutionException, InterruptedException {
        var user = new Faker();
        var drug = drugRepositoryPSQL.getRandom();
        var pharma = pharmaRepositoryPSQL.getRandom();

        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(USER_SCHEMA);
        Injection<GenericRecord, byte[]> recordInjection = GenericAvroCodecs.toBinary(schema);

        GenericData.Record avroRecord = new GenericData.Record(schema);
        avroRecord.put("str1", "Str 1-" + 0);
        avroRecord.put("str2", "Str 2-" + 0);
        avroRecord.put("int1", 0);

        byte[] bytes = recordInjection.apply(avroRecord);

        producer.send("avroTopic", bytes);
    }




    public void listen(Consummer consummer) {
        consummer.subscribe();
    }
    public void listen(AvroConsumer consummer) {
        consummer.subscribe();
    }




}
