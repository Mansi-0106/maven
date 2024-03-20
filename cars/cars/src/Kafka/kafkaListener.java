package com.practice.Assessment3.Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaListener {
    @KafkaListener(topics="oktest", groupId="springtest")
    void listener(String data){
        System.out.println(data);
    }
}