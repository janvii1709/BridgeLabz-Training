import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "largefile.csv"; // Replace with your large CSV file path
        int chunkSize = 100;               // Number of lines to process at a time
        int totalRecords = 0;              // Total records processed
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            // Read header (optional)
            String header = br.readLine();
            if (header != null) {
                System.out.println("Header: " + header);
            }
            // Read file in chunks
            while ((line = br.readLine()) != null) {
                count++;
                totalRecords++;
                // Process line here
                // For demo, we just print line number every 100 lines
                if (count % chunkSize == 0) {
                    System.out.println("Processed " + totalRecords + " records so far...");
                    count = 0; // reset chunk counter
                }
            }
            // Print remaining records if any
            if (count > 0) {
                System.out.println("Processed " + totalRecords + " records in total.");
            } else {
                System.out.println("Finished processing " + totalRecords + " records in total.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        }
    }
}
