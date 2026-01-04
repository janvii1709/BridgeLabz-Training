import java.util.Scanner;
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input size
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        String[] str = new String[n];
        // Input strings
        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            str[i] = sc.nextLine();
        }
        // Create object of Solution
        LongestCommonPrefix LCP = new LongestCommonPrefix();
        // Function call
        String result = LCP.longestCommonPrefix(str);
        // Output
        System.out.println("Longest Common Prefix: " + result);
    }
}
