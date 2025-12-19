import java.util.Scanner;
class SimpleInterest{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input scanner
        double principal = sc.nextDouble(); // taking principal amount as input
        double rate = sc.nextDouble(); // taking Rate of interest as input
        double time = sc.nextDouble(); // taking  Time in years as input
        double simpleInterest = (principal * rate * time) / 100;// Calculate simple interest
        System.out.println("Simple Interest is " + simpleInterest);
        
    }
}