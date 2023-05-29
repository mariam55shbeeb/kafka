package com.example.notificationservice.controller;

import com.example.basedomains.dto.MyNotification;
import com.example.notificationservice.producers.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
@Controller
public class NotificationController {
    @Autowired
    private NotificationProducer notificationProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody MyNotification notification){
        notificationProducer.sendMessage(notification);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}
