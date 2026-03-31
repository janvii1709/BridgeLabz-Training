import java.util.Scanner;
public class KBeautyCalculator {
    // Function to calculate k-beauty
    public static int kBeauty(long num, int k) {
        String numStr = String.valueOf(num);
        int count = 0;
        for (int i = 0; i <= numStr.length() - k; i++) {
            String subStr = numStr.substring(i, i + k);  
            // Convert substring to number
            long subNum = Long.parseLong(subStr);
            // Skip if subNum is 0 (cannot divide)
            if (subNum == 0) continue;
            // Check if subNum divides num
            if (num % subNum == 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number (num): ");
        long num = sc.nextLong();
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        if (num <= 0 || k <= 0) {
            System.out.println("num and k must be positive integers.");
            return;
        }
        int result = kBeauty(num, k);
        System.out.println("The k-beauty of " + num + " for k = " + k + " is: " + result);
    }
}
