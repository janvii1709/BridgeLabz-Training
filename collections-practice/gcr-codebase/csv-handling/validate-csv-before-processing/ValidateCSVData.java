import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "contacts.csv";
        // Regex pattern for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Read header
            if (line == null) {
                System.out.println("CSV file is empty!");
                return;
            }
            System.out.println("Invalid records found:");
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] data = line.split(",");
                String email = data[2].trim();
                String phone = data[3].trim();
                boolean isValid = true;
                // Validate email
                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Line " + lineNumber + ": Invalid Email -> " + email);
                    isValid = false;
                }
                // Validate phone number (10 digits)
                if (!phone.matches("\\d{10}")) {
                    System.out.println("Line " + lineNumber + ": Invalid Phone Number -> " + phone);
                    isValid = false;
                }
                if (isValid) {
                    // Optional: print valid record
                    // System.out.println("Line " + lineNumber + " is valid.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        }
    }
}
