import java.lang.reflect.Method;
import java.util.Scanner;
public class TestTaskInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Take method name from user
            System.out.print("Enter method name to inspect: ");
            String methodName = sc.nextLine();
            // Load class
            Class<TaskManager> cls = TaskManager.class;
            // Get method dynamically
            Method method = cls.getMethod(methodName);
            // Check if annotation is present
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("\n--- Task Information ---");
                System.out.println("Priority   : " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            } else {
                System.out.println("No @TaskInfo annotation found on this method.");
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
