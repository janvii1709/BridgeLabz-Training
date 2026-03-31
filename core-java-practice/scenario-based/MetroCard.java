import java.util.*;
public class MetroCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take initial smart card balance from the user
        System.out.print("Enter the initial smart card balance ");
        double balance = sc.nextDouble();
        // Loop continues until balance is exhausted or user quits
        while(balance > 0){
            System.out.println("Current Balance : " + balance);
            // now taking the input of the distance
            System.out.print("Enter the distance in KiloMeters or press -1 to exit ");
            int Distance = sc.nextInt();
            // Exit condition for the metro
            if(Distance == -1 ){
                System.out.println("Thank you for visiting Delhi Metro ");
                break;
            } 
             // Calculating the fare using ternary operator
            int Fare = (Distance <= 10) ? 30 :
                       (Distance <= 25) ? 70 : 100;// # Distance ≤ 10 km → INR 30 # Distance 11–25 km → ₹70   Distance > 25 km → ₹100
            // Check if sufficient balance is available
            if (balance >= Fare) {
                balance = balance - Fare;
                System.out.println("Fare INR " + Fare + " deducted successfully.");
            } else {
                System.out.println("Insufficient balance. Please recharge.");
                break;


        }

    }
    // Message to be displayed when balance becomes zero
    if (balance <= 0) {
            System.out.println("Balance Has Been Exhausted. Card Is Been Blocked Now !.");
    }
}
}
