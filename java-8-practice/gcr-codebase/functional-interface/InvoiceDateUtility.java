import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
interface DateFormatter {
    static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
public class InvoiceDateUtility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year (YYYY): ");
        int year = sc.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter day (1-31): ");
        int day = sc.nextInt();
        Date invoiceDate = new Date(year - 1900, month - 1, day);
        sc.nextLine();
        System.out.print("Enter desired date format (e.g., dd/MM/yyyy or yyyy-MM-dd): ");
        String pattern = sc.nextLine();
        String formattedDate = DateFormatter.formatDate(invoiceDate, pattern);
        System.out.println("\nFormatted Invoice Date: " + formattedDate);
    }
}
