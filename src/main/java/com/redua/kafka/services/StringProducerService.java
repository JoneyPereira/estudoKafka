package com.redua.kafka.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("str-topic", message).addCallback(
                success -> log.info("Send message with success {}", message),
                error -> log.error("Error send message")
        );
    }
}
