import java.util.Scanner;
public class ExceptionPropagation {
    static void method1(int number) {
        int result = 10 / number;
        System.out.println("Result: " + result);
    }
    static void method2(int number) {
        method1(number);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        try {
            method2(num);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurred!");
        } finally {
        }
    }
}
