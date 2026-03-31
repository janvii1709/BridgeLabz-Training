import java.util.Scanner;
public class MinTimeVisitPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of points : ");
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        // Read points
        System.out.println("Enter the points (x y) :");
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            
        }
        int totalTime = 0;
        for (int i = 1; i < n; i++) {
            int x1 = points[i - 1][0];
            int y1 = points[i - 1][1];
            int x2 = points[i][0];
            int y2 = points[i][1];
            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);
            totalTime += Math.max(dx, dy);
        }
        System.out.println("The minimum time is : " + totalTime);
    }
}
