package com.tsvetanv.notification;

import com.tsvetanv.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notifications")
@AllArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping(path="/{notificationId}")
    public NotificationResponse getNotification(@PathVariable("notificationId") Integer notificationId){
        NotificationResponse notificationResponse = notificationService.getNotification(notificationId);
        log.info("Get notification {}", notificationResponse);
        return notificationResponse;
    }

    @PostMapping
    public void createNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("created notification {}",  notificationRequest);
        notificationService.createNotification(notificationRequest);
    }
}
