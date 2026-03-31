import java.util.Scanner;
class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the OLD feature. It is deprecated!");
    }
    public void newFeature(String message) {
        System.out.println("This is the NEW feature: " + message);
    }
}
public class TestDeprecated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LegacyAPI api = new LegacyAPI();
        System.out.println("Choose method to call:");
        System.out.println("1 - oldFeature (deprecated)");
        System.out.println("2 - newFeature");
        System.out.print("Enter choice (1 or 2): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        if (choice == 1) {
            System.out.println("\nCalling oldFeature():");
            api.oldFeature();  // IDE/compiler shows warning
        } else if (choice == 2) {
            System.out.print("Enter message for the new feature: ");
            String msg = sc.nextLine();
            System.out.println("\nCalling newFeature():");
            api.newFeature(msg);
        } else {
            System.out.println("Invalid choice!");
        }
    }
}
