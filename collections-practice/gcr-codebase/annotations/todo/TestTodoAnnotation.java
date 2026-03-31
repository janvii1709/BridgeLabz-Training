import java.lang.reflect.Method;
import java.util.Scanner;
public class TestTodoAnnotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // User inputs class name
            System.out.print("Enter class name to scan TODOs: ");
            String className = sc.nextLine();
            Class<?> cls = Class.forName(className);
            System.out.println("\n--- Pending Tasks (TODO) ---");
            boolean found = false;
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Todo.class)) {
                    Todo todo = method.getAnnotation(Todo.class);
                    System.out.println("Method      : " + method.getName());
                    System.out.println("Task        : " + todo.task());
                    System.out.println("Assigned To : " + todo.assignedTo());
                    System.out.println("Priority    : " + todo.priority());
                    System.out.println("------------------------------");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No pending TODO tasks found.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
