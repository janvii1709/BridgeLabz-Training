import java.util.*;
public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // input a number from user
        int org = n ; // store original number
        int sum = 0; // initialize sum variable
        while (org != 0){
            int digit = org % 10; // extracting the last digit
            sum = sum + (digit * digit * digit);// cubing the digit and adding it to sum
            org = org / 10; // removing the last digit using division
        }
        if (sum == n){ // checking if sum is equal to original number
            System.out.println(n + " is an Armstrong number");// print if number is Armstrong number
        }
        else {// if not equal
            System.out.println(n + " is not an Armstrong number");// print if number is not Armstrong number
        }
    }
    
}

