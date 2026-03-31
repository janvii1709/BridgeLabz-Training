import java.util.Scanner;

public class InvoiceGenerator {

    // Method to split invoice string into tasks
    static String[] parseInvoice(String input) {
        return input.split(",");
    }

    // Method to calculate total amount
    static int getTotalAmount(String[] tasks) {

        int total = 0;

        for (String task : tasks) {

            // Example task: Logo Design - 3000 INR
            String[] parts = task.split("-");

            String amountPart = parts[1].trim(); // 3000 INR
            String amount = amountPart.replace("INR", "").trim();

            total = total + Integer.parseInt(amount);
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Accepting input in required format
        System.out.println("Enter invoice details in this format:");

        String input = sc.nextLine();   // user enters full line

        // Parsing invoice
        String[] tasks = parseInvoice(input);

        System.out.println("\nInvoice Items:");
        for (String t : tasks) {
            System.out.println(t.trim());
        }

        // Calculating total
        int totalAmount = getTotalAmount(tasks);

        System.out.println("\nTotal Invoice Amount: " + totalAmount + " INR");
    }
}
