import java.lang.reflect.*;
import java.util.Scanner;
public class GetClassInformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full class name (e.g. java.lang.String): ");
        String className = sc.nextLine();
        try {
            // Load the class dynamically
            Class<?> cls = Class.forName(className);
            System.out.println("\nClass Name: " + cls.getName());
            // Display Constructors
            System.out.println("\n--- Constructors ---");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                System.out.println(c);
            }
            // Display Fields
            System.out.println("\n--- Fields ---");
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f);
            }
            // Display Methods
            System.out.println("\n--- Methods ---");
            Method[] methods = cls.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found. Please enter a valid class name.");
        }
    }
}
