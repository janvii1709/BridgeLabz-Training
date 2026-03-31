import java.util.*;
public class BmiStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = 10; // number of persons
        double[][] Persons_Data = new double[Num][2]; // [weight, height]
        String[][] Bmi_Data = new String[Num][4]; // weight, height, BMI, status
        // Input weight and height for 10 persons
        for (int i = 0; i < Num; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            Persons_Data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            Persons_Data[i][1] = sc.nextDouble();
            // Calculate BMI
            double Weight = Persons_Data[i][0];
            double heightCm = Persons_Data[i][1];
            double heightMtr = heightCm / 100.0;
            double BMI = Weight / (heightMtr * heightMtr);

            // Determine status based on updated ranges
            String Status;
            if (BMI <= 18.4) {
                Status = "Underweight";
            } else if (BMI >= 18.5 && BMI <= 24.9) {
                Status = "Normal";
            } else if (BMI >= 25.0 && BMI <= 39.9) {
                Status = "Overweight";
            } else { // bmi >= 40.0
                Status = "Obese";
            }
        

            // Store data as strings
            // Bmi_Data[i][0] = String.format("%.2f", Weight);
            // Bmi_Data[i][1] = String.format("%.2f", heightCm);
            // Bmi_Data[i][2] = String.format("%.2f", BMI);
            // Bmi_Data[i][3] = Status;
        

        // Display BMI results here
        System.out.println("Person " + (i + 1) + " -> Weight: " + Weight + " kg, Height: " + heightCm + " cm, BMI: " + String.format("%.2f", BMI) + ", Status: " + Status);
            System.out.println();

    }
    }
}
