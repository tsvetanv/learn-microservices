package com.tsvetanv.notification;

import com.tsvetanv.clients.notification.NotificationRequest;
import com.tsvetanv.clients.notification.NotificationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationResponse getNotification(Integer notificationId) {
        Notification notification = repository.getById(notificationId);
        NotificationResponse notificationResponse = new NotificationResponse(
                notification.getNotificationId(),
                notification.getToCustomerId(),
                notification.getToCustomerEmail(),
                notification.getSender(),
                notification.getMessage(),
                notification.getSentAt());
        return notificationResponse;
    }

    public void createNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .toCustomerId(request.toCustomerId())
                .toCustomerEmail(request.toCustomerName())
                .sender("Tsvetanv")
                .message(request.message())
                .sentAt(LocalDateTime.now())
                .build();
        repository.saveAndFlush(notification);
    }
}
