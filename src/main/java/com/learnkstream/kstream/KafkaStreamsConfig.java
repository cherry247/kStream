package com.learnkstream.kstream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@Configuration
@EnableKafkaStreams
public class KafkaStreamsConfig {

    @Value("${input.topic}")
    private String inputTopic;

    @Value("${output.topic}")
    private String outputTopic;

    @Bean
    public KStream<String, String> kStream(StreamsBuilder streamsBuilder) {
        KStream<String, String> stream = streamsBuilder.stream(inputTopic, Consumed.with(Serdes.String(), Serdes.String()));

        stream.foreach(((key, value) -> {
            System.out.println("hii " + value);
        }));

        stream
                .mapValues(value -> value.toUpperCase())
                .to(outputTopic,
                        Produced.with(Serdes.String(), Serdes.String()));

        return stream;
    }
}
