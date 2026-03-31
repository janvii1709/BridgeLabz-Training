package JSONProblems;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Iterator;
public class PrintJsonKeysValues {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/java/JSONProblems/datas.json");
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            String jsonData = sb.toString();
            if (jsonData.trim().startsWith("[")) {
                JSONArray jsonArray = new JSONArray(jsonData);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    printJsonObject(obj);
                    System.out.println("-----------------");
                }

            } else {
                JSONObject jsonObject = new JSONObject(jsonData);
                printJsonObject(jsonObject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void printJsonObject(JSONObject obj) {
        Iterator<String> keys = obj.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = obj.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
