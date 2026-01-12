import java.util.Scanner;

public class ThirdMaximum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Take array input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //Find third maximum
        int result = thirdMax(nums);

        //Print result
        System.out.println("Third distinct maximum (or maximum if less than 3 distinct): " + result);
    }

    // Function to find third distinct maximum
    public static int thirdMax(int[] nums) {
        // Initialize 3 max values to minimum possible
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums) {
            if (num == first || num == second || num == third) continue; // skip duplicates

            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }

        return (third == Long.MIN_VALUE) ? (int)first : (int)third;
    }
}
