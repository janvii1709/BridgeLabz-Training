import java.util.*;
public class ExcelColumnTitle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter column number: ");
        int columnNumber = sc.nextInt();
        String Output = "";
        int n = columnNumber;
        while (n > 0) {
            // Adjusting forthe 1-indexed letters (A=1..Z=26)
            n--;
            char ch = (char) ('A' + n % 26);
            // prepending the character
            Output = ch + Output;
            n = n / 26;
        }
        System.out.println("The Excel Column Title is : " + Output);
    }
}
