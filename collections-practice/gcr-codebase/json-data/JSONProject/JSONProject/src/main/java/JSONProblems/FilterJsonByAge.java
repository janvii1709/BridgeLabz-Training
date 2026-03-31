package JSONProblems;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class FilterJsonByAge {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/java/JSONProblems/students.json");
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            String jsonData = sb.toString();
            JSONArray jsonArray = new JSONArray(jsonData);
            JSONArray filteredArray = new JSONArray();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                int age = obj.getInt("age");
                if (age > 25) {
                    filteredArray.put(obj);
                }
            }
            System.out.println("Filtered JSON (age > 25):");
            System.out.println(filteredArray.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
