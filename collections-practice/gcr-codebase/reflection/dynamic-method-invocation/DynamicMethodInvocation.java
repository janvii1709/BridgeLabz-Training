import java.lang.reflect.Method;
import java.util.Scanner;
public class DynamicMethodInvocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Load class dynamically
            Class<?> cls = Class.forName("MathOperations");
            Object mathObj = cls.getDeclaredConstructor().newInstance();
            // Take user input
            System.out.print("Enter method to call (add, subtract, multiply): ");
            String methodName = sc.nextLine();
            System.out.print("Enter first number: ");
            int a = sc.nextInt();
            System.out.print("Enter second number: ");
            int b = sc.nextInt();
            // Get method dynamically
            Method method = cls.getMethod(methodName, int.class, int.class);
            // Invoke method
            Object result = method.invoke(mathObj, a, b);
            System.out.println("Result: " + result);
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found. Please check the method name.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
