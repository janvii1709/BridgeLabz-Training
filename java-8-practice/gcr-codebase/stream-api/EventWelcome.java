import java.util.*;
public class EventWelcome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of attendees:");
        int n = sc.nextInt();
        sc.nextLine();
        List<String> attendees = new ArrayList<>();
        System.out.println("Enter attendee names:");
        for (int i = 0; i < n; i++) {
            attendees.add(sc.nextLine());
        }
        System.out.println("\nWelcome Messages:");
        attendees.stream()
                 .forEach(name -> System.out.println("Welcome, " + name + "!"));
    }
}
