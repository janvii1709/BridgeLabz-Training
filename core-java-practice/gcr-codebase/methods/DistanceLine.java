import java.util.Scanner;
public class  DistanceLine  {

    // Method to calculate Euclidean distance
    public static double CalculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    // Method to calculate slope (m) and y-intercept (b)
    public static double[] CalculateLineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);   // slope
        double b = y1 - m * x1;            // y-intercept
        return new double[] { m, b };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for first point
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();

        // Taking input for second point
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        // Distance calculation
        double distance = CalculateDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance = " + distance);

        // Line equation calculation
        double[] line = CalculateLineEquation(x1, y1, x2, y2);
        System.out.println("Equation of Line: y = " + line[0] + "x + " + line[1]);
    }
}
