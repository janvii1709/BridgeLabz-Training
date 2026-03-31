import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
class Member {
    private String name;
    private LocalDate expiryDate;
    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
    public String getName() {
        return name;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
public class ExpiringMemberships {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Enter number of members:");
        int n = sc.nextInt();
        sc.nextLine();
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Member " + (i + 1) + " Name:");
            String name = sc.nextLine();
            LocalDate expiryDate = null;
            while (expiryDate == null) {
                try {
                    System.out.println("Enter Member " + (i + 1) + " Expiry Date (yyyy-MM-dd):");
                    String dateStr = sc.nextLine();
                    expiryDate = LocalDate.parse(dateStr, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please enter in yyyy-MM-dd format.");
                }
            }

            members.add(new Member(name, expiryDate));
        }

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        System.out.println("\nMembership Status:");

        members.forEach(m -> {
            if (m.getExpiryDate().isBefore(today)) {
                System.out.println(m.getName() + " | Expiry Date: " + m.getExpiryDate() + " (Expired)");
            } else if (!m.getExpiryDate().isAfter(next30Days)) {
                System.out.println(m.getName() + " | Expiry Date: " + m.getExpiryDate() + " (Expiring Soon)");
            }
        });
    }
}
