package com.artemnizhnyk.someapp.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaProducer {

    private  final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(final String message) {
        kafkaTemplate.send("kafka-test", message);
    }
}
