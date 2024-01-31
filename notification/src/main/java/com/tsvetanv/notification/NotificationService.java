package com.tsvetanv.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationResponse getNotification(Integer notificationId) {
        Notification notification = repository.getById(notificationId);
        return new NotificationResponse(notification.getId(), notification.getMessage());
    }

    public void createNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .message(request.message())
                .build();
        repository.saveAndFlush(notification);
    }
}
