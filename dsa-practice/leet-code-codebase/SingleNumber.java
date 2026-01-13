import java.util.Scanner;

public class SingleNumber {

    // Method to find the single number
    public static int findSingleNumber(int[] nums) {

        int result = 0;

        // XOR all elements
        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }

    // Main method with user input
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int single = findSingleNumber(nums);

        System.out.println("Single number is: " + single);

        sc.close();
    }
}
