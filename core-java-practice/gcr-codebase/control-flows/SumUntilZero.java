import java.util.*;
public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double Sum = 0.0;// variable to store the sum
        double num;// variable to store user input
        num = sc.nextDouble();// read user input
        while (num != 0) { // loop until the input is zero
            Sum = Sum + num;// add the input to sum
            num = sc.nextDouble();// read next input
        }
        System.out.println("Total Sum = " + Sum);// print the total sum
    }
}

