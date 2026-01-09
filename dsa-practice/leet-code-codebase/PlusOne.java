import java.util.Scanner;
public class PlusOne {
    public static void main(String[] args) {
        // Scanner for taking user input
        Scanner sc = new Scanner(System.in);

        // Asking for size of the digits array
        System.out.print("Enter number of digits: ");
        int n = sc.nextInt();

        // Creating the digits array
        int[] digits = new int[n];

        //  Taking digits as input
        System.out.print("Enter the digits : ");
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        // Here we start adding 1 from the last digit
        for (int i = n - 1; i >= 0; i--) {

            // If digit is less than 9, simply add 1 and finish
            if (digits[i] < 9) {
                digits[i]++;
                break;
            }

            // If digit is 9, make it 0 and carry goes to next digit
            digits[i] = 0;

            // If we are at first digit and it was 9
            if (i == 0) {
                // Creating a new array with one extra space
                int[] result = new int[n + 1];
                result[0] = 1; // carry added at beginning

                // Copying the  remaining digits
                for (int j = 1; j <= n; j++) {
                    result[j] = digits[j - 1];
                }

                // Printing result and exit
                System.out.print("Result : ");
                for (int num : result) {
                    System.out.print(num + " ");
                }
                return;
            }
        }

        // Printing the updated digits array
        System.out.print(" The Result is : ");
        for (int num : digits) {
            System.out.print(num + " ");
        }
    }
}
