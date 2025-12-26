import java.util.Scanner;
public class UnitConverter2 {
    // Convert yards to feet
    public static double convertYardsToFeet(double yards) {
        return yards * 3; // 1 yard = 3 feet
    }

    // Convert feet to yards
    public static double convertFeetToYards(double feet) {
        return feet * 0.333333; // 1 foot = 1/3 yard
    }

    // Convert meters to inches
    public static double convertMetersToInches(double meters) {
        return meters * 39.3701; // 1 meter = 39.3701 inches
    }

    // Convert inches to meters
    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254; // 1 inch = 0.0254 meters
    }

    // Convert inches to centimeters
    public static double convertInchesToCentimeters(double inches) {
        return inches * 2.54; // 1 inch = 2.54 cm
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Yards to Feet
        System.out.print("Enter distance in yards: ");
        double yards = sc.nextDouble();
        System.out.println(yards + " yards is " + convertYardsToFeet(yards) + " feet.");

        // Feet to Yards
        System.out.print("Enter distance in feet: ");
        double feet = sc.nextDouble();
        System.out.println(feet + " feet is " + convertFeetToYards(feet) + " yards.");

        // Meters to Inches
        System.out.print("Enter distance in meters: ");
        double meters = sc.nextDouble();
        System.out.println(meters + " meters is " + convertMetersToInches(meters) + " inches.");

        // Inches to Meters
        System.out.print("Enter distance in inches: ");
        double inches = sc.nextDouble();
        System.out.println(inches + " inches is " + convertInchesToMeters(inches) + " meters.");

        // Inches to Centimeters
        System.out.print("Enter distance in inches: ");
        inches = sc.nextDouble();
        System.out.println(inches + " inches is " + convertInchesToCentimeters(inches) + " centimeters.");
    }
}
