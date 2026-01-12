import java.util.Scanner;

public class MoveZeros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take array input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //Move zeros to the end
        moveZeros(nums);

        //Print the result
        System.out.println("Array after moving zeros: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // Function to move zeros to the end
    public static void moveZeros(int[] nums) {
        int n = nums.length;
        int insertPos = 0; // position to insert non-zero element

        // Move all non-zero elements forward
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[insertPos++] = nums[i];
            }
        }

        // Fill remaining positions with 0
        while (insertPos < n) {
            nums[insertPos++] = 0;
        }
    }
}
 
