import java.util.Scanner;

public class RemoveElements {

    // Method to remove all occurrences of val in-place
    public static int removeElement(int[] nums, int val) {
        int index = 0; // position to place next valid element

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i]; // copy element if it's not val
                index++;
            }
        }

        return index; // number of elements not equal to val
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User input: array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // User input: array elements
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // User input: value to remove
        System.out.print("Enter value to remove: ");
        int val = sc.nextInt();

        // Call method
        int k = removeElement(nums, val);

        // Print results
        System.out.println("\nNumber of elements not equal to " + val + ": " + k);
        System.out.print("Array after removal (first " + k + " elements are valid): ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
