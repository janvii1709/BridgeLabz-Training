import java.util.*;
class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float num1 = sc.nextFloat();// taking input of first number
        float num2 = sc.nextFloat();// taking input of second number
        float add = num1 + num2 ;// addition of two numbers
        float sub = num1 - num2;// subtraction of two numbers
        float mul = num1 * num2;// multiplication of two numbers
        float div = num1 / num2;// division of two numbers
        System.out.println("The addition , subtraction , multiplication and division value of 2 numbers " + num1 + " and " + num2 + " is "  + add + " , " + sub + " , " + mul + " and " + div);
    }
}