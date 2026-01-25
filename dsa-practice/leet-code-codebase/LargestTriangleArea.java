import java.util.Scanner;
public class LargestTriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Number of points
        System.out.print("Enter number of points: ");
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        // Taking input
        System.out.println("Enter the points (x y):");
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        double maxArea = 0.0;
        // Check all combinations of 3 points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = Math.abs(points[i][0] * (points[j][1] - points[k][1]) +points[j][0] * (points[k][1] - points[i][1]) +points[k][0] * (points[i][1] - points[j][1])) / 2.0;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        System.out.printf("Largest Triangle Area: %.5f", maxArea);
    }
}
