import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest {
    public static void main(String[] args) {

        // Scanner is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Asking user for the size of the array
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        //  Creating an array of given size
        int[] nums = new int[n];

        // Taking array elements from the user
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //Taking the target value
        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        // Sorting the array
        // Sorting helps us use the two-pointer technique easily
        Arrays.sort(nums);

        //  Assuming the first three elements form the closest sum initially
        int closestSum = nums[0] + nums[1] + nums[2];

        //Fixing one element and find the other two using two pointers
        for (int i = 0; i < n - 2; i++) {

            // Left pointer starts just after the fixed element
            int left = i + 1;

            // Right pointer starts from the end of the array
            int right = n - 1;

            // Move pointers until they meet
            while (left < right) {

                // Calculate sum of current three numbers
                int currentSum = nums[i] + nums[left] + nums[right];

                // Checking if current sum is closer to target than previous closest sum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // If current sum is smaller than target,
                // move left pointer to increase the sum
                if (currentSum < target) {
                    left++;
                }
                // If current sum is greater than target,
                // move right pointer to decrease the sum
                else if (currentSum > target) {
                    right--;
                }
                // If current sum exactly equals target,
                // this is the best possible answer
                else {
                    System.out.println("Closest Sum: " + currentSum);
                    return;
                }
            }
        }

        //  Printing the final closest sum
        System.out.println("The Closest Sum is : " + closestSum);
    }
}
