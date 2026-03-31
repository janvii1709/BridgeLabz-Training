// Import LocalDate class to perform date operations
import java.time.LocalDate;
import java.util.Scanner;
public class DateArithmatic {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);
        // Ask user to enter a date in YYYY-MM-DD format
        System.out.print("Enter a date (YYYY-MM-DD): ");
        String InputDate = sc.nextLine();
        // Convert the input string into LocalDate object
        LocalDate Date = LocalDate.parse(InputDate);
        // Add 7 days, 1 month and 2 years to the given date
        LocalDate AddedDate = Date.plusDays(7)
                                  .plusMonths(1)
                                  .plusYears(2);

        // Subtract 3 weeks from the updated date
        LocalDate FinalDate = AddedDate.minusWeeks(3);
        // Display the original date
        System.out.println("Original Date : " + Date);
        // Display the date after addition
        System.out.println("After adding 7 days, 1 month and 2 years : " + AddedDate);
        // Display the final date after subtraction
        System.out.println("After subtracting 3 weeks : " + FinalDate);
    }
}
