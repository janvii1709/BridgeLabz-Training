import java.util.Scanner;
public class NumberType2 {
    // Method to check if number is positive
    public static boolean IsPositive(int Number) {
        return Number >= 0;
    }
    // Method to check if number is even
    public static boolean IsEven(int Number) {
        return Number % 2 == 0;
    }

    // Method to compare two numbers
    // returns 1 if num1 > num2, 0 if equal, -1 if num1 < num2
    public static int compare(int Num1, int Num2) {
        if (Num1 > Num2)
            return 1;
        else if (Num1 == Num2)
            return 0;
        else
            return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] Numbers = new int[5];
        // Taking input
        System.out.print("Enter 5 numbers:");
        for (int i = 0; i < Numbers.length; i++) {
            Numbers[i] = sc.nextInt();
        }

        // Checking positive/negative and even/odd
        for (int i = 0; i < Numbers.length; i++) {
            if (IsPositive(Numbers[i])) {
                System.out.print(Numbers[i] + " is Positive and ");
                if (IsEven(Numbers[i]))
                    System.out.println("Even");
                else
                    System.out.println("Odd");
            } else {
                System.out.println(Numbers[i] + " is Negative");
            }
        }

        // Comparing first and last elements
        int Output = compare(Numbers[0], Numbers[Numbers.length - 1]);

        if (Output == 1)
            System.out.println("First element is Greater than Last element");
        else if (Output == 0)
            System.out.println("First and Last elements are Equal");
        else
            System.out.println("First element is Less than Last element");
    }
}
