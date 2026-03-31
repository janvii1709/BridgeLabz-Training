
import java.util.Scanner;

public class CollinearPoints {

    // Method using slope formula
    public static boolean IsCollinearBySlope(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        double SlopeAB = (y2 - y1) / (x2 - x1);
        double SlopeBC = (y3 - y2) / (x3 - x2);
        double SlopeAC = (y3 - y1) / (x3 - x1);

        return SlopeAB == SlopeBC && SlopeBC == SlopeAC;
    }

    // Method using area of triangle formula
    public static boolean IsCollinearByArea(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        double Area = 0.5 * (
                x1 * (y2 - y3)
              + x2 * (y3 - y1)
              + x3 * (y1 - y2)
        );

        return Area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        boolean SlopeCheck = IsCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean AreaCheck = IsCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("Collinear using Slope Formula: " + SlopeCheck);
        System.out.println("Collinear using Area Formula: " + AreaCheck);
    }
}