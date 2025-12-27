import java.util.Scanner;
public class Temperature {
    // Method to convert Fahrenheit to Celsius
    static double FahrenheitToCelsius(double F) {
        return (F - 32) * 5 / 9;
    }
    // Method to convert Celsius to Fahrenheit
    static double CelsiusToFahrenheit(double C) {
        return (C * 9 / 5) + 32;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Conversion:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter your choice: ");
        int Choice = sc.nextInt();
        if (Choice == 1) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double F = sc.nextDouble();
            System.out.println("Temperature in Celsius = " + FahrenheitToCelsius(F));
        } 
        else if (Choice == 2) {
            System.out.print("Enter temperature in Celsius: ");
            double C = sc.nextDouble();
            System.out.println("Temperature in Fahrenheit = " + CelsiusToFahrenheit(C));
        } 
        else {
            System.out.println("Invalid choice");
        }
    }
}
