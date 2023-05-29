package com.example.appservice.mappers;

import com.example.appservice.models.Notification;
import com.example.basedomains.dto.MyNotification;

public class NotificationMapper {

    public static Notification map(MyNotification myNotification){
        Notification notification = new Notification();

        notification.setSenderName(myNotification.getSenderName());
        notification.setDate(myNotification.getDate());
        notification.setContent(myNotification.getContent());

        return notification;
    }
}
