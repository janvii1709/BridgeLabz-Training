import java.util.Scanner;
public class Quadratic {

    // Method to find roots of quadratic equation
    public static double[] FindRoots(double a, double b, double c) {

        double Delta = Math.pow(b, 2) - 4 * a * c;

        // If delta is positive → two real roots
        if (Delta > 0) {
            double Root1 = (-b + Math.sqrt(Delta)) / (2 * a);
            double Root2 = (-b - Math.sqrt(Delta)) / (2 * a);
            return new double[] { Root1, Root2 };
        }

        // If delta is zero → one real root
        else if (Delta == 0) {
            double Root = -b / (2 * a);
            return new double[] { Root };
        }

        // If delta is negative → no real roots
        else {
            return new double[] {};
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking input from user
        System.out.print("Enter value of a: ");
        double a = sc.nextDouble();
        System.out.print("Enter value of b: ");
        double b = sc.nextDouble();
        System.out.print("Enter value of c: ");
        double c = sc.nextDouble();
        double[] Roots = FindRoots(a, b, c);
        // Displaying result
        if (Roots.length == 2) {
            System.out.println("Root 1: " + Roots[0]);
            System.out.println("Root 2: " + Roots[1]);
        } 
        else if (Roots.length == 1) {
            System.out.println("Only one root: " + Roots[0]);
        } 
        else {
            System.out.println("No real roots");
        }
    }
}
