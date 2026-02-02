import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        Map<String, Integer> idCount = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String header = br.readLine(); // Read header
            System.out.println("Header: " + header);
            System.out.println("\nDuplicate records found:");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0].trim();
                // Count occurrences of ID
                if (idCount.containsKey(id)) {
                    idCount.put(id, idCount.get(id) + 1);
                    System.out.println(line); // print duplicate row
                } else {
                    idCount.put(id, 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        }
    }
}
