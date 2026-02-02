import java.lang.reflect.Method;
import java.util.Scanner;
public class TestImportantMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // User chooses class to inspect
            System.out.print("Enter class name to inspect: ");
            String className = sc.nextLine();
            // Load class dynamically
            Class<?> cls = Class.forName(className);
            System.out.println("\n--- Important Methods ---");
            boolean found = false;
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    ImportantMethod imp = method.getAnnotation(ImportantMethod.class);
                    System.out.println(
                        "Method: " + method.getName() +
                        ", Level: " + imp.level()
                    );
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No important methods found.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
