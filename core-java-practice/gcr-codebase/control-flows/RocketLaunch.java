import java.util.*;
public class RocketLaunch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input from user
        int counter = sc.nextInt(); // read a value for countdown
        // Countdown using while loop
        while (counter >= 1) {// loop until counter is greater than or equal to 1
            System.out.println(counter);
            counter--;   // decrement the counte
        }
    }
    
}
