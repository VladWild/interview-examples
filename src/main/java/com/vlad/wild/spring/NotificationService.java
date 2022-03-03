package com.vlad.wild.spring;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Как в сервисе NotificationService указать конкретную реализацию Sender'а
 */

@Service
public class NotificationService {

    private final Sender sender;

    public NotificationService(Sender sender) {
        this.sender = sender;
    }

    public void sendEvent() {

        //do something ...

        sender.send();

        //do something ...

    }
}

interface Sender {

    void send();
}

@Component("smsSender")
class SmsSender implements Sender {

    @Override
    public void send() {
        //do something to send by sms
    }
}

@Component("pushSender")
class PushSender implements Sender {

    @Override
    public void send() {
        //do something to send by push
    }
}

@Component("emailSender")
class EmailSender implements Sender {

    @Override
    public void send() {
        //do something to send by email
    }
}
