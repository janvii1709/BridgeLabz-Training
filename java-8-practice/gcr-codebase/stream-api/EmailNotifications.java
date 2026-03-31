import java.util.*;
public class EmailNotifications {
    public static void sendEmailNotification(String email) {
        System.out.println("Notification sent to: " + email);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of users:");
        int n = sc.nextInt();
        sc.nextLine();
        List<String> emails = new ArrayList<>();
        System.out.println("Enter user emails:");
        for (int i = 0; i < n; i++) {
            emails.add(sc.nextLine());
        }
        System.out.println("\nSending Email Notifications:");
        emails.forEach(email -> sendEmailNotification(email));
    }
}
