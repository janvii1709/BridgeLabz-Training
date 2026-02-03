package JSONProblems;

import org.json.JSONArray;
import org.json.JSONObject;
public class StudentJSON {
    public static void main(String[] args) {
        String name = "Janhavi Singh";
        int age = 21;
        String[] subjects = {"Math", "Physics", "Computer Science"};
        JSONObject studentJson = new JSONObject();
        studentJson.put("name", name);
        studentJson.put("age", age);
        JSONArray subjectsArray = new JSONArray();
        for (String subject : subjects) {
            subjectsArray.put(subject);
        }
        studentJson.put("subjects", subjectsArray);
        System.out.println("Student JSON Object:");
        System.out.println(studentJson.toString());
    }
}
