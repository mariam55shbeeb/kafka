package com.example.notificationservice.producers;

import com.example.basedomains.dto.MyNotification;
import com.example.notificationservice.utils.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Service
public class NotificationProducer {
    @Autowired
    KafkaTemplate<String, MyNotification> kafkaTemplate;
        public void sendMessage(MyNotification userMessage) {
            Message<MyNotification> message = MessageBuilder
                    .withPayload(userMessage)
                    .setHeader(KafkaHeaders.TOPIC, AppConstant.TOPIC_NAME)
                    .build();

            kafkaTemplate.send(message);
        }
}
