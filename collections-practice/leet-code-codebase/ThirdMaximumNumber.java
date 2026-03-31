import java.util.*;
public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        Long first = null;
        Long second = null;
        Long third = null;
        for (int num : nums) {
            if ((first != null && num == first) ||
                (second != null && num == second) ||
                (third != null && num == third)) {
                continue;
            }
            if (first == null || num > first) {
                third = second;
                second = first;
                first = (long) num;
            } 
            else if (second == null || num > second) {
                third = second;
                second = (long) num;
            } 
            else if (third == null || num > third) {
                third = (long) num;
            }
        }
        return third == null ? first.intValue() : third.intValue();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Output: " + thirdMax(nums));
    }
}
