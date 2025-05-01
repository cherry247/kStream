package com.learnkstream.kstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
public class KstreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(KstreamApplication.class, args);
    }

}
