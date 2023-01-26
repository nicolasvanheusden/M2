package org.uge.utils.stream;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;

public class SimpleKStreams {
    private static final String INPUT_TOPIC = "users";
    private static final String OUTPUT_TOPIC = "drugAnonymSalesAvro";

    public static void run() throws InterruptedException {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "simpleKStreams");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        StreamsConfig streamsConfig = new StreamsConfig(config);
        Serde<String> stringSerde = Serdes.String();
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> simpleStream = builder.stream("users", Consumed.with(stringSerde,
            stringSerde));
        KStream<String, String> upperCasedStream = simpleStream.mapValues(v -> v.toUpperCase());
        upperCasedStream.to( "users2", Produced.with(stringSerde, stringSerde));
        upperCasedStream.print(Printed.<String, String>toSysOut().withLabel("Upper case"));
        KafkaStreams kafkaStreams = new KafkaStreams(builder.build(),streamsConfig);
        kafkaStreams.start();
        Thread.sleep(35000);
        kafkaStreams.close();
    }
}
