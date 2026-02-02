import java.lang.reflect.Constructor;
import java.util.Scanner;
public class DynamicStudentCreation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Get user input
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter student age: ");
            int age = sc.nextInt();
            // Load Student class dynamically
            Class<?> cls = Class.forName("Student");
            // Get parameterized constructor (String, int)
            Constructor<?> constructor = cls.getDeclaredConstructor(String.class, int.class);
            // Create object dynamically using user input
            Object studentObj = constructor.newInstance(name, age);
            // Display object
            System.out.println("Student object created dynamically: " + studentObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
