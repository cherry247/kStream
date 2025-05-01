package com.learnkstream.kstream;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "test-output", groupId = "test-group")
    public void listen(String message) {
        System.out.println("Received message from test-output: " + message);
    }
}