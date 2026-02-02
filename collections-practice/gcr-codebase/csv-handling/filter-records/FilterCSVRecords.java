import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class FilterCSVRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the CSV file name (with .csv extension): ");
        String filePath = sc.nextLine();
        System.out.print("Enter minimum marks to filter students: ");
        int minMarks = sc.nextInt();
        System.out.println("\nStudents scoring more than " + minMarks + " marks:");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read header
            line = br.readLine();
            if (line == null) {
                System.out.println("CSV file is empty!");
                return;
            }
            // Print header
            System.out.println(line);
            // Read each record
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3]); // Marks column
                if (marks > minMarks) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV file.");
        }
    }
}
