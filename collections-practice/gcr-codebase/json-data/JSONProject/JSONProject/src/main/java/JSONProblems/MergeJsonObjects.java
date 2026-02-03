package JSONProblems;
import org.json.JSONObject;
public class MergeJsonObjects {
    public static void main(String[] args) {
        // First JSON Object
        JSONObject json1 = new JSONObject();
        json1.put("name", "Janhavi Singh");
        json1.put("age", 21);
        // Second JSON Object
        JSONObject json2 = new JSONObject();
        json2.put("email", "janhavi@example.com");
        json2.put("city", "Delhi");
        // Merge json2 into json1
        for (String key : JSONObject.getNames(json2)) {
            json1.put(key, json2.get(key));
        }
        // Print merged JSON
        System.out.println("Merged JSON:");
        System.out.println(json1.toString());
    }
}
