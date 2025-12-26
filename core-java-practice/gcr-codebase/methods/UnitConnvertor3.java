import java.util.Scanner;

public class UnitConnvertor3 {

    // TEMPERATURE CONVERSIONS
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // WEIGHT CONVERSIONS 
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    // VOLUME CONVERSIONS
    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //  TEMPERATURE 
        System.out.print("Enter temperature in Fahrenheit: ");
        double tempF = sc.nextDouble();
        System.out.println(tempF + " F = " + convertFahrenheitToCelsius(tempF) + " C");

        System.out.print("Enter temperature in Celsius: ");
        double tempC = sc.nextDouble();
        System.out.println(tempC + " C = " + convertCelsiusToFahrenheit(tempC) + " F");

        // WEIGHT
        System.out.print("Enter weight in pounds: ");
        double pounds = sc.nextDouble();
        System.out.println(pounds + " lbs = " + convertPoundsToKilograms(pounds) + " kg");

        System.out.print("Enter weight in kilograms: ");
        double kg = sc.nextDouble();
        System.out.println(kg + " kg = " + convertKilogramsToPounds(kg) + " lbs");

        // VOLUME
        System.out.print("Enter volume in gallons: ");
        double gallons = sc.nextDouble();
        System.out.println(gallons + " gallons = " + convertGallonsToLiters(gallons) + " liters");

        System.out.print("Enter volume in liters: ");
        double liters = sc.nextDouble();
        System.out.println(liters + " liters = " + convertLitersToGallons(liters) + " gallons");
    }
}
