import java.util.Scanner;
class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");// taking first number as input
        double a = sc.nextDouble();// taking first number as input
        System.out.print("Enter second number: ");// taking second number as input
        double b = sc.nextDouble();// taking second number as input
        System.out.print("Enter third number: ");// taking third number as input
        double c = sc.nextDouble();//taking third number as input
        double average = (a + b + c) / 3;// calculating average of the three numbers
        System.out.println("Average = " + average);
        sc.close();
    }
}
