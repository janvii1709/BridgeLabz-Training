import java.util.*;
public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // input a number from user
        boolean isPrime = true; // flag to check if a number is prime or not
        if (n <= 1){// check if number is less than or equal to 1
            isPrime = false ; // numbers less than or equal to 1 are not prime
        }
        else{
            for (int i = 2 ; i<= Math.sqrt(n); i++){ // loop from 2 to square root of n
                if (n % i == 0){ // check if n is divisible by i
                    isPrime = false; // if n is divisible by i, then n is not prime
                    break; // exit the loop
                }
            }

        }
        if (isPrime){
            System.out.println(n + " is a prime number");
        }
        else {
            System.out.println(n + " is not a prime number");
        }
    }
}
    

