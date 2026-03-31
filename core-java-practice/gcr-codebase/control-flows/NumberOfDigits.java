import java.util.*;
public class NumberOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // input a number from user
        int count = 0 ;// initialize count variable to store number of digits
        while ( n != 0){
            n = n / 10;
            count++; // increase the count by 1 for each digit

        }
        System.out.println("Number of digits are : " + count); // print number of digits
    }
    
}
