package org.uge.utils.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.uge.utils.Constants;

import java.util.Properties;

public class SimpleProcessor {
    public static void run() {
        var config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "simpleProcessor");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Void().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.ByteArray().getClass());
        var topology = new Topology();

        topology.addSource("buyer", Constants.TOPIC_TOP2); // resp. nom du processor et nom du topic source
        topology.addProcessor("anonymBuyer",AnonymProcessor::new,"buyer");
        var streams = new KafkaStreams(topology, config);
        streams.start();

    }
}