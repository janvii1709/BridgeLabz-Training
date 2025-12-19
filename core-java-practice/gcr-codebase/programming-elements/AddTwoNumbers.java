
import java.util.*;
//Write a program that takes two numbers as input from user and prints their sum
public class AddTwoNumbers {
  public static void main (String [] args){
    Scanner sc=new Scanner(System.in);
    int n =sc.nextInt();// taking first number as input
    int m=sc.nextInt();// taking second number as input
    int sum=n+m;//calculating sum of two numbers
    System.out.println("The sum is :" +  sum);
  }
}