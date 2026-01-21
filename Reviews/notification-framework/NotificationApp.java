import java.util.Scanner;
public class NotificationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Notification Type:");
        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.println("3. Push");
        System.out.println("4. WhatsApp");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter message: ");
        String message = sc.nextLine();
        //used to get the notification object based on the user choice
        Notification notification =NotificationFactory.getNotification(choice);

        if (notification != null) {
            notification.send(message);//used polymorphism here 
        } else {
            System.out.println("Invalid choice ! Enter the correct choice.");
        }
    }
}
