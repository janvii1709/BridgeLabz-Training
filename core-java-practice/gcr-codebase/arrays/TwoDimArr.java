import java.util.Scanner;
public class TwoDimArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking rows input
        System.out.print("Enter number of rows: ");
        int Rows = sc.nextInt();
        // taking columns input
        System.out.print("Enter number of columns: ");
        int Columns = sc.nextInt();
        // Creating 2D array
        int[][] Matrix = new int[Rows][Columns];
        // Taking input for 2D array
        for (int i = 0; i < Rows; i++) { // loop for rows(outer)
            for (int j = 0; j < Columns; j++) { // loop for columns (inner)
                System.out.print("Enter element at [" + i + "][" + j + "]: ");
                Matrix[i][j] = sc.nextInt();
            }
        }
        // Creating 1D array
        int[] Arr = new int[Rows * Columns];
        int INDEX = 0;
        // Copying elements from 2D to 1D
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                Arr[INDEX] = Matrix[i][j];
                INDEX++;
            }
        }
        // 1D array output 
        System.out.println("1D Array elements:");
        for (int i = 0; i < Arr.length; i++) {
            System.out.print(Arr[i] + " ");
        }
    }
}
