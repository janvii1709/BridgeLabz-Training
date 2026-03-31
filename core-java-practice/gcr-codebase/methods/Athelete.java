import java.util.*;
public class Athelete {
    public static double CalculateAtheleteRun(double s1 , double s2 , double s3 ){
        double perimeter = s1 + s2 + s3;// perimter of triange
        double distance = 5000 ; // 5km = 5000 meters
        return(distance / perimeter);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // take input from user
        System.out.print("Enter the first side of triangle : ");
        double s1 = sc.nextDouble();
        System.out.print("Enter the second side of triangle : ");
        double s2 = sc.nextDouble();
        System.out.print("Enter the third side of triangle : ");
        double s3 = sc.nextDouble();
        double Rounds = CalculateAtheleteRun(s1, s2, s3);
        System.out.println("The athlete needs to complete "+ Rounds + " rounds to finish a 5 km run. ");

    }
    
    
}
