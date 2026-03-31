import java.util.*;
class QuotientAndRemainder {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);// input scanner
        int number1 = sc.nextInt();// first number as input
        int number2 = sc.nextInt();// second number as input
        int quo = number1 / number2 ; // calculating quotient
        int rem = number1 % number2 ;// calculating remainder
        System.out.println("The Quotient is " + quo + " and Remainder is " + rem + " of the two numbers " + number1 + " and " + number2 );
    }
    
}
