//Write a program that takes temprature in Celsius as input and converts it to fahrenheit using the formula Fahrenheit =(Celsius*9/5)+32
import java.util.Scanner;
class CelsiusToFahrenheitConversion {
  public static void main(String [] args){
    Scanner sc=new Scanner (System.in);// taking input from user
    double celsius=sc.nextDouble();// taking temperature in celcius 
    double fahrenheit =(celsius*9/5)+32;// conversion of celcius to fahrenheit
    System.out.println(" Fahrenheit: "+  fahrenheit);
  }
}