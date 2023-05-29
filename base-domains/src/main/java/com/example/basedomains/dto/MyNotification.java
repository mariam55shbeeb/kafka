package com.example.basedomains.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyNotification {
    String senderName;
    Date date;
    String content;
}
