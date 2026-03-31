import java.util.Scanner;
public class BMI {
    // Method to calculate BMI and populate the 3rd column of the array
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0]; // weight in kg
            double heightCm = data[i][1]; // height in cm
            double heightM = heightCm / 100; // convert cm to meters
            // BMI formula: weight / (height in meters)^2
            double bmi = weight / (heightM * heightM);
            data[i][2] = bmi; // store BMI in the 3rd column
        }
    }

    // Method to determine BMI status based on BMI value
    public static String[] determineBMIStatus(double[][] data) {
        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];

            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                status[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 40) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int members = 10;
        double[][] teamData = new double[members][3]; // weight, height, BMI

        // Take input for weight and height
        for (int i = 0; i < members; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            teamData[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            teamData[i][1] = sc.nextDouble();
        }

        // Calculate BMI for all members
        calculateBMI(teamData);

        // Determine BMI status for all members
        String[] bmiStatus = determineBMIStatus(teamData);

        // Display the results
        System.out.println("\nPerson\tWeight(kg)\tHeight(cm)\tBMI\tStatus");
        for (int i = 0; i < members; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s\n",
                    i + 1, teamData[i][0], teamData[i][1], teamData[i][2], bmiStatus[i]);
        }
    }
}
