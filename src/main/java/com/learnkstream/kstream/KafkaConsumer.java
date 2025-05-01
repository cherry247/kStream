package com.learnkstream.kstream;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
public class KafkaConsumer {

    @KafkaListener(topics = "test-output", groupId = "test-group")
    public void listen(String message) {
        System.out.println("Received message from test-output: " + message);
    }
}