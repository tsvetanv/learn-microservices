package com.tsvetanv.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "notification",
        path = "api/v1/notifications"
)
public interface NotificationClient {

    @GetMapping(path="/{notificationId}")
    public NotificationResponse getNotification(@PathVariable("notificationId") Integer notificationId);

    @PostMapping
    public void createNotification(@RequestBody NotificationRequest notificationRequest);
}
