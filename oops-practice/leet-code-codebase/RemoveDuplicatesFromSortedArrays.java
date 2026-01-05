import java.util.Scanner;

public class RemoveDuplicatesFromSortedArrays {

    // Method to remove duplicates
    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int index = 1; // position for unique elements

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask for array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Take array input
        System.out.println("Enter elements in sorted order:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call method
        int k = removeDuplicates(nums);

        // Output result
        System.out.println("\nNumber of unique elements: " + k);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}
