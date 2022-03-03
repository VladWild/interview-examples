package com.vlad.wild.spring;

import org.springframework.stereotype.Service;

/**
 * Как в сервисе OrderService взять такой бин NotificationService, внутри которого именно EmailSender?
 */

@Service
public class OrderService {

    private final NotificationService notificationServiceEmailImpl; //EmailSender

    public OrderService(NotificationService notificationServiceEmailImpl) {
        this.notificationServiceEmailImpl = notificationServiceEmailImpl;
    }

    public void createOrder() {

        //do something ...

        notificationServiceEmailImpl.sendEvent();
    }
}
