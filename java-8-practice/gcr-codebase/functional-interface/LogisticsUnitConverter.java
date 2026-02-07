import java.util.Scanner;
interface UnitConverter {
    static double kmToMiles(double km) {
        return km * 0.621371;
    }
    static double kgToLbs(double kg) {
        return kg * 2.20462;
    }
    static double metersToFeet(double meters) {
        return meters * 3.28084;
    }
}
public class LogisticsUnitConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unit Conversion Tool");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Kilograms to Pounds");
        System.out.println("3. Meters to Feet");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        System.out.print("Enter the value to convert: ");
        double value = sc.nextDouble();
        double result = 0;
        switch (choice) {
            case 1:
                result = UnitConverter.kmToMiles(value);
                System.out.printf("%.2f km = %.2f miles%n", value, result);
                break;
            case 2:
                result = UnitConverter.kgToLbs(value);
                System.out.printf("%.2f kg = %.2f lbs%n", value, result);
                break;
            case 3:
                result = UnitConverter.metersToFeet(value);
                System.out.printf("%.2f meters = %.2f feet%n", value, result);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
