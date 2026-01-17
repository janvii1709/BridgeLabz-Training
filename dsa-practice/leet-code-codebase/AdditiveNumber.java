import java.util.*;
public class AdditiveNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number string: ");
        String num = sc.nextLine();
        boolean isAdditive = isAdditiveNumber(num);
        System.out.println("Is additive number? " + isAdditive);
        sc.close();
    }
    // Main function to check additive number
    public static boolean isAdditiveNumber(String num) {
        int n = num.length();
        // Trying all possible first and second numbers
        for (int i = 1; i <= n / 2; i++) {
            String first = num.substring(0, i);
            // leading zero invalid for first number
            if (first.length() > 1 && first.startsWith("0")) continue; 
            for (int j = i + 1; j < n; j++) {
                String second = num.substring(i, j);
                // leading zero invalid for second number
                if (second.length() > 1 && second.startsWith("0")) continue; 
                if (isValidSequence(first, second, num.substring(j))) return true;
            }
        }
        return false;
    }
    // Helping to check if the remaining string forms a valid additive sequence
    public static boolean isValidSequence(String first, String second, String remaining) {
        while (!remaining.isEmpty()) {
             // adding as strings
            String sum = stringAdd(first, second);
            if (!remaining.startsWith(sum)) return false;
            remaining = remaining.substring(sum.length());
            first = second;
            second = sum;
        }
        return true;
    }
    // Function to add two numbers represented as strings
    public static String stringAdd(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--; j--;
        }
        return sb.reverse().toString();
    }
}
