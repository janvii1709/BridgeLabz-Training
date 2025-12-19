import java.util.Scanner;
public class SumUntilZero2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double Sum = 0.0;// variable to store the sum
        // read numbers until a zero or negative number is entered
        while (true) {
            double num = sc.nextDouble();// read user input
            if (num <= 0) {// check for zero or negative input
                break;
            }
            Sum = Sum + num;// add theinput to sum
        }
        System.out.println("Total sum = " + Sum);// print the total sum
    }
}
