package JSONProblems;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class CsvToJsonConverter {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/java/JSONProblems/data.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("CSV file is empty!");
                br.close();
                return;
            }

            String[] headers = headerLine.split(",");

            JSONArray jsonArray = new JSONArray();
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                JSONObject obj = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], values[i]);
                }
                jsonArray.put(obj);
            }

            br.close();

            System.out.println("Converted JSON Array:");
            System.out.println(jsonArray.toString(4));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
