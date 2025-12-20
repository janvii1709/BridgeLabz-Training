import java.util.*;
public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // input a number from user
        int org = n ; // store original number
        int sum = 0; // initialize sum variable
        while(n != 0){// loop to calculate the sum of digits
            int digit = n % 10; // get last digit
            sum = sum + digit; // add digit to sum
            n = n / 10; // remove the last digit

        }
        // checking the Harshad number condition 
        if (org % sum == 0){
            System.out.println(org + " is a Harshad number"); // print if number is a Harshad number
        }
        else {
            System.out.println(org + " is Not a Harshad number");//print if number is not a Harshad number
        }
    }
}
