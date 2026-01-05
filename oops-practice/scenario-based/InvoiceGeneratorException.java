import java.util.Scanner;

// This is our own custom exception
// We use it when invoice format is wrong
class InvalidInvoiceFormatException extends Exception {

    // This constructor sends a custom error message
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGeneratorException {

    // This method checks whether the invoice input is correct or not
    // If format is wrong, it throws an exception
    public static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {

        // Split the full invoice using comma
        // Example: "Task1 - 3000 INR, Task2 - 4000 INR"
        String[] tasks = input.split(",");

        // Check each task one by one
        for (String task : tasks) {

            // Remove extra spaces
            task = task.trim();

            // If dash (-) is missing, format is wrong
            if (!task.contains("-")) {
                throw new InvalidInvoiceFormatException(
                        "Invalid format: '-' missing in task -> " + task
                );
            }

            // Split task name and amount using dash
            String[] parts = task.split("-");

            // If amount part is missing after dash
            if (parts.length < 2 || parts[1].trim().isEmpty()) {
                throw new InvalidInvoiceFormatException(
                        "Invalid format: Amount missing in task -> " + task
                );
            }

            // Remove everything except numbers from amount
            // Example: "3000 INR" becomes "3000"
            String amountPart = parts[1].replaceAll("[^0-9]", "").trim();

            // If no number is found, amount is missing
            if (amountPart.isEmpty()) {
                throw new InvalidInvoiceFormatException(
                        "Invalid format: Amount not found in task -> " + task
                );
            }

            // Check whether amount is a valid number
            try {
                Integer.parseInt(amountPart);
            } catch (NumberFormatException e) {
                throw new InvalidInvoiceFormatException(
                        "Invalid format: Amount is not numeric in task -> " + task
                );
            }
        }

        // If all tasks are valid, return them
        return tasks;
    }

    // This method calculates the total invoice amount
    public static int getTotalAmount(String[] tasks) {

        int total = 0;

        // Go through each task and add its amount
        for (String task : tasks) {
            String[] parts = task.split("-");
            String amount = parts[1].replaceAll("[^0-9]", "").trim();
            total += Integer.parseInt(amount);
        }

        // Return final total
        return total;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask user to enter invoice details
        System.out.println("Enter invoice details:");
        String input = sc.nextLine();

        try {
            // Check invoice format
            String[] tasks = parseInvoice(input);

            // Print all invoice items
            System.out.println("\nInvoice Items:");
            for (String task : tasks) {
                System.out.println(task.trim());
            }

            // Calculate and print total amount
            int total = getTotalAmount(tasks);
            System.out.println("\nTotal Amount: " + total + " INR");

        } catch (InvalidInvoiceFormatException e) {
            // Show clear error message if input is wrong
            System.out.println("Error: " + e.getMessage());
        }
    }
}
