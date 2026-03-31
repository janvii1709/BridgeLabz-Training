import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class SearchEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the employee name to search: ");
        String searchName = sc.nextLine().trim();
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String line = br.readLine(); // Read header
            if (line == null) {
                System.out.println("CSV file is empty!");
                return;
            }
            // Read each record
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[1].trim();
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("\nEmployee Found:");
                    System.out.println("Name      : " + name);
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary    : " + data[3]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee '" + searchName + "' not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        }
    }
}
