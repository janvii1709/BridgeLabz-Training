import java.util.Scanner;

public class Bmi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();// input weight from user
        double heightInCm = sc.nextDouble();// input height from user in cm 
        double heightInMtr = heightInCm / 100 ; // converting height in cm to m
        double BMI = weight / (heightInMtr * heightInMtr); // calculating BMI
        System.out.println("BMI is: " +  BMI);
        // determine the status
        if (BMI <= 18.4){
            System.out.println("Status : Underweight");
        }
        else if(BMI >= 18.5 && BMI <25.0){
            System.out.println("Status: Normal ");
        } else if (BMI >= 25 && BMI < 40) {
            System.out.println("Status: Overweight");
        } else {
            System.out.println("Status: Obese");
        }

        }
    }
