package com.bardev.kafka.producer.controller;

import com.bardev.kafka.producer.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/message/{message}")
    public ResponseEntity<?> sendMessage(@PathVariable("message") String message ){

        messageService.write(message);
        return ResponseEntity.ok(message);
    }

}
