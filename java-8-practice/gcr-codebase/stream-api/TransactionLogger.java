import java.time.LocalDateTime;
import java.util.*;
public class TransactionLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of transactions:");
        int n = sc.nextInt();
        sc.nextLine();
        List<String> transactionIds = new ArrayList<>();
        System.out.println("Enter transaction IDs:");
        for (int i = 0; i < n; i++) {
            transactionIds.add(sc.nextLine());
        }
        System.out.println("\nLogging Transactions:");
        transactionIds.forEach(id -> 
            System.out.println(LocalDateTime.now() + " - Transaction: " + id)
        );
    }
}
