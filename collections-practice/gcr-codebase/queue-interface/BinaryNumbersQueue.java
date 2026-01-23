import java.util.*;
public class BinaryNumbersQueue {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        for (int i = 0; i < N; i++) {
            String front = queue.remove();
            result.add(front);
            queue.add(front + "0");
            queue.add(front + "1");
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = sc.nextInt();
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println("First " + N + " binary numbers: " + binaryNumbers);
    }
}
