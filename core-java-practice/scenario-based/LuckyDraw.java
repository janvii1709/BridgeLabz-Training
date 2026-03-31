import java.util.Scanner;
public class LuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of visitors: ");
        int Visitors = sc.nextInt();

        for (int i = 1; i <= Visitors; i++) {
            System.out.print("Enter number for visitor " + i + ": ");
            int Num = sc.nextInt();
            // Invalid input check
            if (Num <= 0) {
                System.out.println("Invalid number, try next visitor");
                continue;
            }

            // Lucky draw condition
            if (Num % 3 == 0 && Num % 5 == 0) {
                System.out.println("Congratulations! You won a gift");
            } else {
                System.out.println("Better luck next time");
            }
        }
    }
}
