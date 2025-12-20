import java.util.*;
public class FizzArr{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int n = sc.nextInt();
        // checking if the number is positive or not
        if (n < 0) {
            System.out.println("Please enter a positive integer");
            return;
        }
        // Creating String array
        String[] Res = new String[n + 1];
        // Saving values in array
        for (int i = 0; i <= n; i++) {
            if (i != 0 && i % 3 == 0 && i % 5 == 0) {
                Res[i] = "FizzBuzz";
            } else if (i != 0 && i % 3 == 0) {
                Res[i] = "Fizz";
            } else if (i != 0 && i % 5 == 0) {
                Res[i] = "Buzz";
            } else {
                Res[i] = String.valueOf(i);
            }
        }
        // Now taking the output (result) here
        for (int i = 1; i <= n; i++) {
            System.out.println("Position " + i + " = " + Res[i]);
        }
    }
}
