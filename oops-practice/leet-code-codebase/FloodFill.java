import java.util.*;
public class FloodFill {
    public static void floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color)
            return;
        dfs(image, sr, sc, originalColor, color);
    }
    public static void dfs(int[][] image, int r, int c,int originalColor, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n)
            return;
        if (image[r][c] != originalColor)
            return;
        image[r][c] = newColor;
        dfs(image, r + 1, c, originalColor, newColor);
        dfs(image, r - 1, c, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor);
        dfs(image, r, c - 1, originalColor, newColor);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int m = sc.nextInt();
        System.out.print("Enter columns: ");
        int n = sc.nextInt();
        int[][] image = new int[m][n];
        System.out.println("Enter image matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter starting row (sr): ");
        int sr = sc.nextInt();
        System.out.print("Enter starting column (sc): ");
        int scCol = sc.nextInt();
        System.out.print("Enter new color: ");
        int color = sc.nextInt();
        floodFill(image, sr, scCol, color);
        System.out.println("Updated Image:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
