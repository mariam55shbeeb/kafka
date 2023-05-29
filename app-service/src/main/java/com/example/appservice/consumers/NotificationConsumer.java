package com.example.appservice.consumers;

import com.example.appservice.mappers.NotificationMapper;
import com.example.basedomains.dto.MyNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import com.example.appservice.repositories.ChatRepository;

public class NotificationConsumer {
    @Autowired(required = true)
    public ChatRepository chatRepository;

    @KafkaListener(topics = "${spring.kafka.topic.name}" , groupId = "${spring.kafka.consumer.group-id}")
    public void consume(MyNotification message) {
        System.out.println("Message from" +
                message.getSenderName() + " at " + message.getDate() + " content is " + message.getContent());

        chatRepository.save(NotificationMapper.map(message));
    }
}