import java.util.Scanner;
class LargestOddNumberInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        String num = sc.nextLine();
        String result = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 == 1) {
                result = num.substring(0, i + 1);
                break;
            }
        }
        System.out.println("The Largest Odd Number In String Is : " + result);
    }
}
