public class NotificationFactory {
// used here to get the notification object
    public static Notification getNotification(int choice) {

        if (choice == 1) return new EmailNotification();
        if (choice == 2) return new SMSNotification();
        if (choice == 3) return new PushNotification();
        if (choice == 4) return new WhatsAppNotification();

        return null;
    }
}
