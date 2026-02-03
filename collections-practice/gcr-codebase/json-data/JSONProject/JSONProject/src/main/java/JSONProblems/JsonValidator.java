package JSONProblems;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonValidator {
    public static boolean isValidJSON(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // Try parsing the JSON
            mapper.readTree(json);
            return true;
        } catch (Exception e) {
            // Invalid JSON
            return false;
        }
    }
    public static void main(String[] args) {
        // Example JSON strings
        String validJson = "{\"name\":\"Janhavi\",\"age\":21,\"email\":\"janhavi@example.com\"}";
        String invalidJson = "{\"name\":\"Janhavi\", \"age\":21,,}";
        System.out.println("Valid JSON check: " + isValidJSON(validJson));   // true
        System.out.println("Invalid JSON check: " + isValidJSON(invalidJson)); // false
    }
}
