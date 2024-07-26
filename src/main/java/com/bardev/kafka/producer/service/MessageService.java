package com.bardev.kafka.producer.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageService.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "sample-topic", groupId = "1")
    public void write(String message){

        log.info(message);
        kafkaTemplate.send("sample-topic", message);
    }

}
