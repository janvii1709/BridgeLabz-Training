import java.lang.reflect.Method;
import java.util.Scanner;
public class MethodExecutionTimer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Load class dynamically
            Class<?> cls = MathOperations.class;
            Object obj = cls.getDeclaredConstructor().newInstance();
            // Ask user for method name
            System.out.print("Enter method to execute (add / multiply): ");
            String methodName = sc.nextLine();
            // Ask for method parameters
            System.out.print("Enter first number: ");
            int a = sc.nextInt();
            System.out.print("Enter second number: ");
            int b = sc.nextInt();
            // Get method dynamically
            Method method = cls.getMethod(methodName, int.class, int.class);
            // Measure execution time
            long startTime = System.nanoTime();
            method.invoke(obj, a, b);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Execution time: " + duration + " nanoseconds");
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found. Check the method name.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
