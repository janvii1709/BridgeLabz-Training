package JSONProblems;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class ValidateEmailJson {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/java/JSONProblems/user.json");
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            JSONObject jsonData = new JSONObject(new JSONTokener(sb.toString()));

            // Step 3: Extract email field
            if (!jsonData.has("email")) {
                System.out.println("Email field is missing ");
                return;
            }
            String email = jsonData.getString("email");
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                System.out.println("Email is valid : " + email);
            } else {
                System.out.println("Email is invalid : " + email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
