
public class MatrixOperationBasics   {

    // Create random matrix
    public static int[][] CreateRandomMatrix(int Rows, int Cols) {
        int[][] Mat = new int[Rows][Cols];
        for (int i = 0; i < Rows; i++)
            for (int j = 0; j < Cols; j++)
                Mat[i][j] = (int)(Math.random() * 10);
        return Mat;
    }

    // Add matrices
    public static int[][] Add(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    // Subtract matrices
    public static int[][] Subtract(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    // Multiply matrices
    public static int[][] Multiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    // Display matrix
    public static void display(int[][] M) {
        for (int[] Rows : M) {
            for (int val : Rows)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = CreateRandomMatrix(2, 3);
        int[][] B = CreateRandomMatrix(2, 3);
        int[][] C = CreateRandomMatrix(3, 2);

        System.out.println("Matrix A:");
        display(A);
        System.out.println("Matrix B:");
        display(B);

        System.out.println("Addition:");
        display(Add(A, B));

        System.out.println("Subtraction:");
        display(Subtract(A, B));

        System.out.println("Multiplication (A x C):");
        display(Multiply(A, C));
    }
}