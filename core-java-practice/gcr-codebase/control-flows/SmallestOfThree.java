
import java.util.Scanner;

public class SmallestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// Input from user
        // Input three numbers from user+
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        // check if the first number is the smallest among the three
        if (n1 < n2 && n1 < n3) {
            System.out.println("Is the first number the smallest? Yes");
        }
        else {
            System.out.println("Is the first number the smallest? No");
        }
    }
}