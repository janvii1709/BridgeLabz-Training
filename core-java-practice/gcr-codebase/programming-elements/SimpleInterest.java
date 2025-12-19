import java.util.Scanner;
class SimpleInterest{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double principal = sc.nextDouble(); // Principal amount
        double rate = sc.nextDouble();         // Rate of interest
        double time = sc.nextDouble();         // Time in years
        // Calculate simple interest
        double simpleInterest = (principal * rate * time) / 100;
        // Print the simple interest
        System.out.println("Simple Interest is " + simpleInterest);
    }
}