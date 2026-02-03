import java.util.*;

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];

        for (int i = 0; i < nums.length; i++) {

            // if last element OR next element is not consecutive
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {

                if (start == nums[i]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i]);
                }

                // start new range if not last element
                if (i != nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter sorted unique elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<String> ranges = summaryRanges(nums);

        System.out.println("Output:");
        System.out.println(ranges);
    }
}
