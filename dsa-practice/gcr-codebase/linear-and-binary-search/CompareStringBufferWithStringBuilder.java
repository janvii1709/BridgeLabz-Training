import java.util.*;

public class CompareStringBufferWithStringBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of times to concatenate string : ");
        int n = sc.nextInt();

        // StringBuffer 
        StringBuffer stringBuffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime();

        for (int i = 0; i < n; i++) {
            stringBuffer.append("hello");
        }

        long endTimeBuffer = System.nanoTime();
        long bufferTime = endTimeBuffer - startTimeBuffer;

        // StringBuilder 
        StringBuilder stringBuilder = new StringBuilder();
        long startTimeBuilder = System.nanoTime();

        for (int i = 0; i < n; i++) {
            stringBuilder.append("hello");
        }

        long endTimeBuilder = System.nanoTime();
        long builderTime = endTimeBuilder - startTimeBuilder;

        System.out.println("\nTime taken by StringBuffer  : " + bufferTime + " nanoseconds");
        System.out.println("Time taken by StringBuilder : " + builderTime + " nanoseconds");
    }
}
