package JSONProblems;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.XML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class JsonToXmlConverter {

    public static void main(String[] args) {
        try {
            // Step 1: Read JSON file into a String
            File file = new File("src/main/java/JSONProblems/data1.json");
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();

            // Step 2: Convert JSON string to JSONObject
            JSONObject json = new JSONObject(new JSONTokener(sb.toString()));

            // Step 3: Convert JSONObject to XML string
            String xml = XML.toString(json);

            // Step 4: Print XML
            System.out.println("Converted XML:");
            System.out.println(xml);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
