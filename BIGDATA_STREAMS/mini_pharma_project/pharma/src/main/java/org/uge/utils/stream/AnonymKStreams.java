package org.uge.utils.stream;

import com.twitter.bijection.Injection;
import com.twitter.bijection.avro.GenericAvroCodecs;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.uge.models.Person;
import org.uge.utils.Constants;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class AnonymKStreams {
    private static final String INPUT_TOPIC = Constants.TOPIC_ANONYM;
    private static final String OUTPUT_TOPIC = Constants.TOPIC_DRUGS_ANONYM_SALES_AVRO;

    public static void run() throws InterruptedException, URISyntaxException, IOException {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "simpleKStreams");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        StreamsConfig streamsConfig = new StreamsConfig(config);
        Serde<String> stringSerde = Serdes.String();
        StreamsBuilder builder = new StreamsBuilder();
        KStream<Void, byte[]> simpleStream = builder.stream(INPUT_TOPIC, Consumed.with(Serdes.Void(), Serdes.ByteArray()));

        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(Person.openSchema());
        Injection<GenericRecord, byte[]> recordInjection = GenericAvroCodecs.toBinary(schema);

        KStream<Void, String> upperCasedStream = simpleStream
            .mapValues(v -> {
            var record = recordInjection.invert(v).get();
            return new Person(
                record.get("firstName").toString(),
                record.get("lastName").toString(),
                (Long) record.get("cip"),
                (Double) record.get("price"),
                (Long) record.get("idPharma")
            );
        }).filter((k, v) -> v.price() > 4.0)
            .mapValues(Person::toString);


        upperCasedStream.to(OUTPUT_TOPIC, Produced.with(Serdes.Void(), stringSerde));
        upperCasedStream.print(Printed.<Void, String>toSysOut().withLabel("Anonym drug sold > 4€"));

        KafkaStreams kafkaStreams = new KafkaStreams(builder.build(),streamsConfig);
        kafkaStreams.start();
        Thread.sleep(35000);
        kafkaStreams.close();
    }
}
