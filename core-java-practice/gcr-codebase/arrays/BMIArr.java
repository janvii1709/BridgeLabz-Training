import java.util.*;
public class BMIArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input number of persons
        System.out.print("Enter the number of persons: ");
        int n = sc.nextInt();
        // Arrays to store data
        double[] Weight = new double[n];   // Weight in kg
        double[] Height = new double[n];   // Height in cm
        double[] BMI = new double[n];      // BMI
        String[] Status = new String[n];   // Weight status
        // Input weight and height for each person from user
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Person " + (i + 1));
            System.out.print("Enter weight (kg): ");
            Weight[i] = sc.nextDouble();
            System.out.print("Enter height (cm): ");
            Height[i] = sc.nextDouble();
            // Validation of the data entered is valid or not
            if (Weight[i] <= 0 || Height[i] <= 0) {
                System.out.println("Invalid input! Please enter again.");
                i--; // Re-enter data
            }
        }
        // Calculate BMI and determining the status based on it
        for (int i = 0; i < n; i++) {
            double heightInM = Height[i] / 100;           // Convert cm to meters
            BMI[i] = Weight[i] / (heightInM * heightInM); // BMI formula
            if (BMI[i] <= 18.4) {
                Status[i] = "Underweight";
            } else if (BMI[i] >= 18.5 && BMI[i] < 25.0) {
                Status[i] = "Normal";
            } else if (BMI[i] >= 25.0 && BMI[i] < 40.0) {
                Status[i] = "Overweight";
            } else {
                Status[i] = "Obese";
            }
        }
        // Display the height , weight , bmi and status of each person
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Weight: " + Weight[i] + " kg");
            System.out.println("Height: " + Height[i] + " cm");
            System.out.printf("BMI: %.2f\n", BMI[i]);
            System.out.println("Status: " + Status[i]);
        }

    }
    
}

