package com.tsvetanv.clients.notification;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface NotificationClient {

    @GetMapping(path="/{notificationId}")
    public NotificationResponse getNotification(@PathVariable("notificationId") Integer notificationId);

    @PostMapping
    public void createNotification(@RequestBody NotificationRequest notificationRequest);
}
