import java.lang.reflect.Method;
import java.util.Scanner;
public class TestLogExecutionTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            PerformanceService service = new PerformanceService();
            Class<?> cls = service.getClass();
            // User chooses which method to execute
            System.out.print("Enter method name to execute: ");
            String methodName = sc.nextLine();
            Method method = cls.getMethod(methodName);
            // Check annotation
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(service);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Execution Time: " + duration + " nanoseconds");
            } else {
                method.invoke(service);
                System.out.println("Execution time logging not enabled for this method.");
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
