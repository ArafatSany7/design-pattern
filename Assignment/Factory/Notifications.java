
abstract class Notification {
    public abstract void send();
}

class SMSNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS Notification.");
    }
}

class EmailNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending Email Notification.");
    }
}

class NullNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Unsupported Notification Type.");
    }
}

class NotificationFactory {
    public enum NotificationType {
        SMS, EMAIL
    }

    public static Notification getNotification(NotificationType type) {
        if (type == null) {
            return new NullNotification();
        }

        switch (type) {
            case SMS:
                return new SMSNotification();
            case EMAIL:
                return new EmailNotification();
            default:
                return new NullNotification();
        }
    }
}

public class Notifications {
    public static void main(String[] args) {
        Notification smsNotification = NotificationFactory.getNotification(NotificationFactory.NotificationType.SMS);
        smsNotification.send();

        Notification emailNotification = NotificationFactory
                .getNotification(NotificationFactory.NotificationType.EMAIL);
        emailNotification.send();

        Notification unsupportedNotification = NotificationFactory.getNotification(null);
        unsupportedNotification.send();
    }
}
