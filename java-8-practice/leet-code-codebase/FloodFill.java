import java.util.Scanner;
public class FloodFill {
    static void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }
        if (image[r][c] != originalColor) {
            return;
        }
        image[r][c] = newColor;
        dfs(image, r + 1, c, originalColor, newColor);
        dfs(image, r - 1, c, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor);
        dfs(image, r, c - 1, originalColor, newColor);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();
        int[][] image = new int[m][n];
        System.out.println("Enter image values:");
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
        int originalColor = image[sr][scCol];
        if (originalColor != color) {
            dfs(image, sr, scCol, originalColor, color);
        }
        System.out.println("Image after Flood Fill:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
