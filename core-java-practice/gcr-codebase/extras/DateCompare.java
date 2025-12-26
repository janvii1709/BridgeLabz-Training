// Import LocalDate class to work with dates
import java.time.LocalDate;
import java.util.Scanner;

public class DateCompare {
    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Take first date input from user
        System.out.print("Enter first date (YYYY-MM-DD): ");
        String FirstInput = sc.nextLine();

        // Take second date input from user
        System.out.print("Enter second date (YYYY-MM-DD): ");
        String SecondInput = sc.nextLine();

        // Convert input strings to LocalDate objects
        LocalDate Date1 = LocalDate.parse(FirstInput);
        LocalDate Date2 = LocalDate.parse(SecondInput);

        // Compare the two dates
        if (Date1.isBefore(Date2)) {
            System.out.println("First date is BEFORE the second date");
        } 
        else if (Date1.isAfter(Date2)) {
            System.out.println("First date is AFTER the second date");
        } 
        else {
            System.out.println("Both dates are the SAME");
        }
    }
}
