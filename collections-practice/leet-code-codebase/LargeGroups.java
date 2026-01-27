import java.util.*;
public class LargeGroups {
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
            }
            int end = i;
            if (end - start + 1 >= 3) {
                List<Integer> group = new ArrayList<>();
                group.add(start);
                group.add(end);
                result.add(group);
            }
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();
        List<List<Integer>> output = largeGroupPositions(s);
        System.out.println(output);
    }
}
