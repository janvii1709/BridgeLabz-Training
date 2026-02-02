import java.lang.reflect.Field;
import java.util.Scanner;
public class AccessPrivateField {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Create object
            Person person = new Person();
            // Get Class object
            Class<?> cls = person.getClass();
            // Access private field 'age'
            Field ageField = cls.getDeclaredField("age");
            ageField.setAccessible(true); // bypass private access
            // Get current value
            int currentAge = (int) ageField.get(person);
            System.out.println("Current Age: " + currentAge);
            // Take user input
            System.out.print("Enter new age: ");
            int newAge = sc.nextInt();
            // Modify private field
            ageField.set(person, newAge);
            // Retrieve updated value
            int updatedAge = (int) ageField.get(person);
            System.out.println("Updated Age: " + updatedAge);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
