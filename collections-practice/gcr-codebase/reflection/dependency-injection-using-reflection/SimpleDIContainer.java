import java.lang.reflect.Field;
import java.util.Scanner;
public class SimpleDIContainer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Ask user which service to inject
            System.out.print("Enter service to use (EmailService / SMSService): ");
            String serviceName = sc.nextLine();
            // Create Client object dynamically
            Client client = new Client();
            Class<?> clientClass = client.getClass();
            // Scan fields for @Inject
            for (Field field : clientClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    // Determine service implementation
                    Object serviceImpl = null;
                    if (serviceName.equalsIgnoreCase("EmailService")) {
                        serviceImpl = new EmailService();
                    } else if (serviceName.equalsIgnoreCase("SMSService")) {
                        serviceImpl = new SMSService();
                    } else {
                        System.out.println("Invalid service name. Using default EmailService.");
                        serviceImpl = new EmailService();
                    }
                    // Inject dependency
                    field.set(client, serviceImpl);
                }
            }
            // Take message input
            System.out.print("Enter message to send: ");
            String msg = sc.nextLine();
            // Call method on client
            client.process(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
