import java.util.*;
public class RocketLaunch2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input from user
        int counter = sc.nextInt(); // read a value for countdown
        // countdown using for loop
        for( int i = counter; i>=1 ; i--){
            System.out.println(i);
        }
        
    }
    
}
