import java.util.*;

public class WindSpeed {

    public static double CalculateTheSpeedOfWind(double Temperature, double WindSpeed) {
        return 35.74 + 0.6215 * Temperature
                + (0.4275 * Temperature - 35.75) * Math.pow(WindSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking input from user
        System.out.print("Enter the temperature : ");
        double Temperature = sc.nextDouble();

        System.out.print("Enter the speed : ");
        double WindSpeed = sc.nextDouble();

        double WindChill = CalculateTheSpeedOfWind(Temperature, WindSpeed);

        System.out.println("The WindChill Temperature is : " + WindChill);
    }
}
