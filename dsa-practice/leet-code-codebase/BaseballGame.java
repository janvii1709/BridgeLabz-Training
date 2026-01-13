import java.util.Scanner;
public class BaseballGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take number of operations
        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        String[] ops = new String[n];
        // Take operations input
        System.out.println("Enter operations:");
        for (int i = 0; i < n; i++) {
            ops[i] = sc.nextLine();
        }
        // Array to store record scores
        int[] record = new int[n];
        int top = -1; // points to last valid score
        // Process operations
        for (int i = 0; i < n; i++) {
            String op = ops[i];
            if (op.equals("C")) {
                // Remove last score
                top--;
            } else if (op.equals("D")) {
                // Double last score
                int doubled = 2 * record[top];
                record[++top] = doubled;
            } else if (op.equals("+")) {
                // Sum of last two scores
                int sum = record[top] + record[top - 1];
                record[++top] = sum;
            } else {
                // Integer value
                int value = Integer.parseInt(op);
                record[++top] = value;
            }
        }
        // Calculate total sum
        int totalSum = 0;
        for (int i = 0; i <= top; i++) {
            totalSum += record[i];
        }
        // Output result
        System.out.println("Total Score: " + totalSum);
    }
}
