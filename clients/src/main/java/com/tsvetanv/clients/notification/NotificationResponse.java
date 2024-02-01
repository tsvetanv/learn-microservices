package com.tsvetanv.clients.notification;

public class NotificationResponse {
    private Integer id;

    private String message;

    public NotificationResponse() {
    }

    public NotificationResponse(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
