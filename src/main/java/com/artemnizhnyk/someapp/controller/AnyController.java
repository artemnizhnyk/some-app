package com.artemnizhnyk.someapp.controller;

import com.artemnizhnyk.someapp.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AnyController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/kafka/send")
    public String send(@RequestBody final String message) {

        kafkaProducer.sendMessage(message);

        return "Success";
    }
}
