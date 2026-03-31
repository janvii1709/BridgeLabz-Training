import java.util.Scanner;
public class MayasBmi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number Of Clients : ");
        int clients = sc.nextInt();
        int ClientNumb = 1; // for client categorising as cleint 1 , client 2 ,....
        while(clients > 0){
            System.out.println("Client : " + ClientNumb) ;
        System.out.print("Enter weight in kilograms: ");
        double weight = sc.nextDouble();// input weight from user
        System.out.print("Enter height in centimeters: ");
        double heightInCm = sc.nextDouble();// input height from user in cm
        double heightInMtr = heightInCm / 100 ; // height is taken in meters
        double BMI = weight / (heightInMtr * heightInMtr); // calculating BMI
        System.out.printf("BMI is: %.2f%n", BMI);
        if (BMI < 18.5){
            System.out.println(" Category : Underweight");
        }
        else if(BMI >= 18.5 && BMI <25.0){
            System.out.println("Category : Normal Weight ");
        }else {
            System.out.println("Category: Overweight");
        }
        clients-- ; // decrementing the client count each time after the BMI is calculated
        ClientNumb ++; // increasing it for counting the client each time after completing the BMI calculation 
    }

        }
    }