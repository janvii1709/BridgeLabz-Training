import java.io.*;
import java.util.*;

import javax.tools.JavaFileObject;

import org.json.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class JsonCsvConverter {
    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(jsonFile)));
            JSONArray jsonArray = new JSONArray(content);
            if (jsonArray.length() == 0) {
                System.out.println("JSON file is empty.");
                return;
            }
            FileWriter fw = new FileWriter(csvFile);
            // Write CSV header
            JavaFileObject firstObj = jsonArray.getJSONObject(0);
            List<String> keys = new ArrayList<>(firstObj.keySet());
            fw.append(String.join(",", keys));
            fw.append("\n");
            // Write CSV rows
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                List<String> values = new ArrayList<>();
                for (String key : keys) {
                    values.add(String.valueOf(obj.get(key)));
                }
                fw.append(String.join(",", values));
                fw.append("\n");
            }
            fw.close();
            System.out.println("CSV file generated: " + csvFile);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    // Convert CSV to JSON
    public static void csvToJson(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("CSV file is empty.");
                return;
            }

            String[] headers = headerLine.split(",");
            JSONArray jsonArray = new JSONArray();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject obj = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], values[i]);
                }
                jsonArray.put(obj);
            }

            // Write JSON to file
            FileWriter fw = new FileWriter(jsonFile);
            fw.write(jsonArray.toString(4)); // pretty print with 4 spaces
            fw.close();

            System.out.println("JSON file generated: " + jsonFile);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";
        String jsonOutput = "students_from_csv.json";

        // Convert JSON to CSV
        jsonToCsv(jsonFile, csvFile);

        // Convert CSV back to JSON
        csvToJson(csvFile, jsonOutput);
    }
}
