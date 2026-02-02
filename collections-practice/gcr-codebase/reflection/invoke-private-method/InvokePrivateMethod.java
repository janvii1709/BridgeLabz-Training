import java.lang.reflect.Method;
import java.util.Scanner;
public class InvokePrivateMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Take user input
            System.out.print("Enter first number: ");
            int a = sc.nextInt();
            System.out.print("Enter second number: ");
            int b = sc.nextInt();
            // Create object of Calculator
            Calculator calculator = new Calculator();
            // Get Class object
            Class<?> cls = calculator.getClass();
            // Access private method multiply(int, int)
            Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
            method.setAccessible(true); // bypass private access
            // Invoke method
            int result = (int) method.invoke(calculator, a, b);
            // Display result
            System.out.println("Result of multiplication: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
