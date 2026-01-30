import java.util.Scanner;
public class ArrangingCoins {
    public static int arrangeCoins(int n) {
        return (int)((Math.sqrt(1 + 8L * n) - 1) / 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of coins: ");
        int n = sc.nextInt();
        System.out.println(arrangeCoins(n));
    }
}
