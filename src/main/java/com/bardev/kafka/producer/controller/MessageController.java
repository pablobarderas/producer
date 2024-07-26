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

    @PostMapping("/offer/{id}/{contactNum}/{offer}")
    public ResponseEntity<?> sendMessage(
            @PathVariable("id") Integer id,
            @PathVariable("contactNum") String contactNum
            ,@PathVariable("offer") String offer){

        // BUILD AND SEND MESSAGE
        String offerMessage = String.format("id: %d | contact num: %s | offer: %s", id, contactNum, offer);
        messageService.write(offerMessage);
        return ResponseEntity.ok(offerMessage);
    }

}
