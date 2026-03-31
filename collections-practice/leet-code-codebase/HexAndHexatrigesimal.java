import java.util.Scanner;
public class HexAndHexatrigesimal {
    public static String convertAndConcat(int n) {
        int square = n * n;
        int cube = n * n * n;
        String hex = Integer.toString(square, 16).toUpperCase();
        String base36 = Integer.toString(cube, 36).toUpperCase();
        return hex + base36;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        String result = convertAndConcat(n);
        System.out.println("Output: " + result);
    }
}
