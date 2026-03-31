import java.lang.reflect.Field;
import java.util.Scanner;
public class AccessModifyStaticField {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Get Class object
            Class<?> cls = Configuration.class;
            // Access private static field
            Field field = cls.getDeclaredField("API_KEY");
            field.setAccessible(true); // bypass private access
            // Get current value
            String currentValue = (String) field.get(null);
            System.out.println("Current API_KEY: " + currentValue);
            // Take new value from user
            System.out.print("Enter new API_KEY: ");
            String newApiKey = sc.nextLine();
            // Modify static field value
            field.set(null, newApiKey);
            // Get updated value
            String updatedValue = (String) field.get(null);
            System.out.println("Updated API_KEY: " + updatedValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
