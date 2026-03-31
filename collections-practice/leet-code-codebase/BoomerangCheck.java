import java.util.Scanner;
public class BoomerangCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] points = new int[3][2];
        // Taking input for 3 points
        System.out.println("Enter coordinates of 3 points:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter x" + (i + 1) + ": ");
            points[i][0] = sc.nextInt();
            System.out.print("Enter y" + (i + 1) + ": ");
            points[i][1] = sc.nextInt();
        }
        // Extracting values
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];
        // Area of triangle formula
        int area = x1 * (y2 - y3)
                 + x2 * (y3 - y1)
                 + x3 * (y1 - y2);
        if (area != 0) {
            System.out.println("true (Boomerang)");
        } else {
            System.out.println("false (Not a Boomerang)");
        }
    }
}
