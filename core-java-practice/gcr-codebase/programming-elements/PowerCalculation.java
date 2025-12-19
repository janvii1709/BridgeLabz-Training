import java.util.Scanner;
class PowerCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input scanner
        System.out.print("Enter base: ");// taking base as input
        double b = sc.nextDouble();// taking base as input
        System.out.print("Enter exponent: ");// taking exponent as input
        double ex = sc.nextDouble();// taking exponent as input
        double res = Math.pow(b, ex);// calculating power using Math.pow function
        System.out.println("Result = " + res);
    }
}
