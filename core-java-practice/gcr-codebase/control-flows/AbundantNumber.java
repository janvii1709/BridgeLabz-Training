import java.util.*;
public class AbundantNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // input a number from user
        int sum = 0; // initialize sum variable to store sum of divisors
        // loop to find all divisors and then their sum
        for (int i= 1 ; i < n ; i++){// loop from 1 to less than n
            if(n % i == 0){// checking if i is a divisor
                sum = sum + i; // adding divisor to sum
            }
        }
        // checking the Abundant number condition
        if (sum > n){
            System.out.println(n + " is an Abundant number"); // print if number is an Abundant number
        
        }
        else{
            System.out.println(n + " is Not an Abundant number"); // print if number is not an Abundant number
        }

    }
    
}
