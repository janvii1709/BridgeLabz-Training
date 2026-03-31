import java.io.*;
import java.util.*;
public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";
        // Map to store ID -> student details from file1
        Map<String, String[]> studentMap = new HashMap<>();
        try {
            // Read students1.csv
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            String line = br1.readLine(); // header
            List<String> headers = new ArrayList<>(Arrays.asList(line.split(","))); // store headers

            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentMap.put(data[0], data); // key = ID
            }
            br1.close();
            // Read students2.csv
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            line = br2.readLine(); // header
            String[] headers2 = line.split(",");
            headers.addAll(Arrays.asList(Arrays.copyOfRange(headers2, 1, headers2.length))); // skip ID
            // Prepare output file
            FileWriter fw = new FileWriter(outputFile);
            // Write merged header
            fw.write(String.join(",", headers) + "\n");
            while ((line = br2.readLine()) != null) {
                String[] data2 = line.split(",");
                String id = data2[0];
                if (studentMap.containsKey(id)) {
                    String[] data1 = studentMap.get(id);
                    // Merge data1 and data2 (excluding duplicate ID)
                    List<String> mergedData = new ArrayList<>(Arrays.asList(data1));
                    mergedData.addAll(Arrays.asList(Arrays.copyOfRange(data2, 1, data2.length)));
                    fw.write(String.join(",", mergedData) + "\n");
                }
            }
            br2.close();
            fw.close();
            System.out.println("CSV files merged successfully into: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing CSV files.");
            e.printStackTrace();
        }
    }
}
