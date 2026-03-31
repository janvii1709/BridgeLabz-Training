import java.util.Scanner;
public class StringPower {
    public static int maxPower(String s) {
        int maxPower = 1;
        int currentCount = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            maxPower = Math.max(maxPower, currentCount);
        }
        return maxPower;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = sc.nextLine();
        int result = maxPower(s);
        System.out.println("Power of string: " + result);
    }
}