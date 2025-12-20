import java.util.*;
public class BMI2DArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input number of person
        System.out.print("Enter the number of persons: ");
        int Numb = sc.nextInt();
        // declaring the array
        double[][] Data = new double[Numb][3]; // 0: weight, 1: height, 2: BMI
        String[] Weights_Stat = new String[Numb];    // Weight status of each person
        //Input weight and height from user
        for (int i = 0; i < Numb; i++) {
            System.out.println("Enter details for Person " + (i + 1));
            // Input weight
            System.out.print("Enter weight (kg): ");
            Data[i][0] = sc.nextDouble();
            while (Data[i][0] <= 0) {
                System.out.print("Invalid . Please Enter positive weight: ");
                Data[i][0] = sc.nextDouble();
            }
            // Input height
            System.out.print("Enter height (cm): ");
            Data[i][1] = sc.nextDouble();
            while (Data[i][1] <= 0) {
                System.out.print("Invalid . Please Enter positive height: ");
                Data[i][1] = sc.nextDouble();
            }
        }

        // Calculating BMI and Weight Status
        for (int i = 0; i < Numb; i++) {
            double heightInM = Data[i][1] / 100; // Convert cm to meters
            Data[i][2] = Data[i][0] / (heightInM * heightInM); // BMI
            // Determine weight status
            double BMI = Data[i][2];
            if (BMI <= 18.4) {
                Weights_Stat[i] = "Underweight";
            } else if (BMI >= 18.5 && BMI < 25.0) {
                Weights_Stat[i] = "Normal";
            } else if (BMI >= 25.0 &&BMI < 40.0) {
                Weights_Stat[i] = "Overweight";
            } else {
                Weights_Stat[i] = "Obese";
            }
        }
        //Display the height , weight , bmi and status of each person 
        for (int i = 0; i < Numb; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Weight: " + Data[i][0] + " kg");
            System.out.println("Height: " + Data[i][1] + " cm");
            System.out.printf("BMI: %.2f\n", Data[i][2]);
            System.out.println("Status: " + Weights_Stat[i]);
        }

        
    }
    
}
