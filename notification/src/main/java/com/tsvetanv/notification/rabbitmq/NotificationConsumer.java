package com.tsvetanv.notification.rabbitmq;

import com.tsvetanv.clients.notification.NotificationRequest;
import com.tsvetanv.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumeNotification(NotificationRequest notificationRequest){
        log.info("Consumed message from queue: {}", notificationRequest);
        notificationService.createNotification(notificationRequest);
    }

}
