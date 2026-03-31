package JSONProblems;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
public class MergeJsonFiles {
    private static JSONObject readJsonFile(String filePath) throws Exception {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return new JSONObject(new JSONTokener(sb.toString()));
    }
    private static void mergeJsonObjects(JSONObject target, JSONObject source) {
        Iterator<String> keys = source.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            target.put(key, source.get(key));
        }
    }
    public static void main(String[] args) {
        try {
            JSONObject json1 = readJsonFile("src/main/java/JSONProblems/file1.json");
            JSONObject json2 = readJsonFile("src/main/java/JSONProblems/file2.json");
            mergeJsonObjects(json1, json2);
            System.out.println("Merged JSON Object:");
            System.out.println(json1.toString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
