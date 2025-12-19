//Write a program that takes temprature in Celsius as input and converts it to fahrenheit using the formula Fahrenheit =(Celsius*9/5)+32
import java.util.Scanner;
class CelsiusToFahrenheitConversion {
  public static void main(String [] args){
    Scanner sc=new Scanner (System.in);
    double celsius=sc.nextDouble();
    double fahrenheit =(celsius*9/5)+32;
    System.out.println(" Fahrenheit: "+  fahrenheit);
  }
}