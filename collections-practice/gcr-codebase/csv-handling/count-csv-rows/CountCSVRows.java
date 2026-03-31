import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "employees.csv";  // CSV file path
        int rowCount = 0;                   // Counter for rows
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header row
            br.readLine();
            // Read each line and count
            while (br.readLine() != null) {
                rowCount++;
            }
            // Print the count
            System.out.println("Number of records (excluding header): " + rowCount);
        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        }
    }
}
