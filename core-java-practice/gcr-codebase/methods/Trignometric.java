import java.util.*;
public class Trignometric {
    // Method to calculate sin, cos and tan
    public static double[] CalculateTrigonometricFunction(double Angle) {
        double Radians = Math.toRadians(Angle);   // convert degrees to radians
        double Sin = Math.sin(Radians);
        double Cos = Math.cos(Radians);
        double Tan = Math.tan(Radians);
        return new double[] { Sin, Cos, Tan };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double Angle = sc.nextDouble();
        double[] arr = CalculateTrigonometricFunction(Angle);
        System.out.println("Sine value is : " + arr[0]);
        System.out.println("Cosine value is : " + arr[1]);
        System.out.println("Tangent value is : " + arr[2]);
    }
}
