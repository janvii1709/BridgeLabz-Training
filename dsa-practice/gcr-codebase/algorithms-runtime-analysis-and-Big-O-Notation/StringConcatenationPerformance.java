import java.util.Scanner;
public class StringConcatenationPerformance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for number of concatenations
        System.out.print("Enter the number of strings to concatenate (N): ");
        int n = sc.nextInt();

        System.out.println("\n--- String Concatenation Performance ---");

        //Using String (Immutable, O(N^2))
        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "a"; // creates a new String each time
        }
        long end = System.nanoTime();
        double stringTime = (end - start) / 1_000_000.0;
        System.out.printf("String Concatenation Time: %.5f ms\n", stringTime);

        // Using StringBuilder (Mutable, O(N))
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        end = System.nanoTime();
        double stringBuilderTime = (end - start) / 1_000_000.0;
        System.out.printf("StringBuilder Concatenation Time: %.5f ms\n", stringBuilderTime);

        //  Using StringBuffer (Thread-safe, O(N))
        start = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append("a");
        }
        end = System.nanoTime();
        double stringBufferTime = (end - start) / 1_000_000.0;
        System.out.printf("StringBuffer Concatenation Time: %.5f ms\n", stringBufferTime);

        //Comparing the result
        System.out.println("\nExpected Result:");
        System.out.println("StringBuilder and StringBuffer are much more efficient than String.");
        System.out.println("Use StringBuilder for single-threaded operations.");
        System.out.println("Use StringBuffer for multi-threaded operations.");
    }
}
