
import java.util.Scanner;

class SimpleInterest{
    public static double calculateSimpleInterest(double Principal , double Rate , double Time){
        return (Principal *Rate * Time) / 100;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // taking input from user
        System.out.print("Enter the principal : ");
        double Principal = sc.nextDouble();
        System.out.print("Enter the rate : ");
        double Rate = sc.nextDouble();
        System.out.print("Enter the time : ");
        double Time = sc.nextDouble();
        //calculating the simple interest
        double simpleInterest = calculateSimpleInterest(Principal, Rate, Time);
        System.out.println("The Simple Interest is " + simpleInterest  + " for Principal " + Principal + ", " + "Rate Of Interest " + Rate + " and Time " + Time);

    }

}