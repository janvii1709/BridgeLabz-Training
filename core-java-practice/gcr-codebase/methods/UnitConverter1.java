
import java.util.Scanner;

public class UnitConverter1 {

    // Convert kilometers to miles
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    // Convert miles to kilometers
    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    // Convert meters to feet
    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    // Convert feet to meters
    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Kilometers to Miles
        System.out.print("Enter distance in kilometers: ");
        double km = sc.nextDouble();
        double miles = convertKmToMiles(km);
        System.out.println(km + " km is " + miles + " miles.");

        // Miles to Kilometers
        System.out.print("Enter distance in miles: ");
        miles = sc.nextDouble();
        km = convertMilesToKm(miles);
        System.out.println(miles + " miles is " + km + " km.");

        // Meters to Feet
        System.out.print("Enter distance in meters: ");
        double meters = sc.nextDouble();
        double feet = convertMetersToFeet(meters);
        System.out.println(meters + " meters is " + feet + " feet.");

        // Feet to Meters
        System.out.print("Enter distance in feet: ");
        feet = sc.nextDouble();
        meters = convertFeetToMeters(feet);
        System.out.println(feet + " feet is " + meters + " meters.");
    }
}
