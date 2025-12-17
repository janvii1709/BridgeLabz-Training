import java.util.Scanner;
class PowerCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        double b = sc.nextDouble();
        System.out.print("Enter exponent: ");
        double ex = sc.nextDouble();

        double res = Math.pow(b, ex);

        System.out.println("Result = " + res);

        sc.close();
    }
}
