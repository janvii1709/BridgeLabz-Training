import java.util.Scanner;
public class MinimumFlipsToReverseBinary {
    public static int minFlips(int n) {
        String binary = Integer.toBinaryString(n);
        String reversed = new StringBuilder(binary).reverse().toString();
        int flips = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) != reversed.charAt(i)) {
                flips++;
            }
        }
        return flips;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        int result = minFlips(n);
        System.out.println("Minimum number of flips required: " + result);
    }
}
