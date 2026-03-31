import java.util.*;
public class CalculatorUsingSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double first = sc.nextInt(); // input first number from user
        double second = sc.nextInt(); // input second number from user
        String op = sc.next(); // input operator from user
        // switch case to perform operation based on user input
        switch(op){
            case "+":// addition case
                System.out.println("Addition is : " +(first + second));// print additon
                break;
            case "-":// subtraction case
                System.out.println("Subtraction is : " + (first - second));// print subtraction
                break;
            case "*":// multiplication case
                System.out.println("Multiplication is : " + (first * second));// print multiplication
                break;
            case "/":// division case
                if (second != 0){// check for division by zero
                    System.out.println("Division is : " +(first / second));// print division
                }
                else {// if second number is zero
                    System.out.println("Division by zero is not allowed");// print division by zero error
                }
                break;
            default:// default case
                System.out.println("Invalid Operator");// print invalid operator error
        }
    }
    
}
