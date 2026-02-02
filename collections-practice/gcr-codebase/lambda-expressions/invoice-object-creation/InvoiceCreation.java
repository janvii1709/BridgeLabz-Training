import java.util.*;
import java.util.stream.*;
public class InvoiceCreation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> transactionIds = new ArrayList<>();
        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();
        System.out.println("Enter transaction IDs:");
        for (int i = 0; i < n; i++) {
            transactionIds.add(sc.nextInt());
        }
        // Create Invoice objects using constructor reference
        List<Invoice> invoices = transactionIds.stream().map(Invoice::new).collect(Collectors.toList());
        System.out.println("\nGenerated Invoices:");
        invoices.forEach(System.out::println);
    }
}
