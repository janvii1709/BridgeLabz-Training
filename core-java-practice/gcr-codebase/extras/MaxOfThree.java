import java.util.Scanner;
public class MaxOfThree {
    // Method to take integer input from the user
    public static int TakeInput(Scanner sc, String Message) {
        System.out.print(Message);
        return sc.nextInt();
    }
    // Method to find the maximum of three numbers
    public static int FindMaximum(int a, int b, int c) {
        int Max = a;

        if (b > Max) {
            Max = b;
        }
        if (c > Max) {
            Max = c;
        }

        return Max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take three numbers from the user
        int Num1 = TakeInput(sc, "Enter first number: ");
        int Num2 = TakeInput(sc, "Enter second number: ");
        int Num3 = TakeInput(sc, "Enter third number: ");
        // Calculate the maximum value
        int Maximum = FindMaximum(Num1, Num2, Num3);
        // Display the result
        System.out.println("Maximum of the three numbers is: " + Maximum);
    }
}
