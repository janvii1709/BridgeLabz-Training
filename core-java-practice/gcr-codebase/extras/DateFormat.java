// Import LocalDate class to work with date without time
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateFormat {
    public static void main(String[] args) {
        // Get the current system date
        LocalDate CurrentDate = LocalDate.now();

        // Create formatter for dd/MM/yyyy format
        DateTimeFormatter Format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Create formatter for yyyy-MM-dd format
        DateTimeFormatter Format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Create formatter for EEE, MMM dd, yyyy format
        DateTimeFormatter Format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        // Display date in dd/MM/yyyy format
        System.out.println("Date (dd/MM/yyyy) : " + CurrentDate.format(Format1));

        // Display date in yyyy-MM-dd format
        System.out.println("Date (yyyy-MM-dd) : " + CurrentDate.format(Format2));

        // Display date in EEE, MMM dd, yyyy format
        System.out.println("Date (EEE, MMM dd, yyyy) : " + CurrentDate.format(Format3));
    }
}
