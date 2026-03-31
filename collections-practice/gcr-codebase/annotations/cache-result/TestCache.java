import java.util.Scanner;
public class TestCache {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ExpensiveService service = new ExpensiveService();
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        System.out.println("\nFirst call:");
        Object result1 = CacheExecutor.execute(service, "square", number);
        System.out.println("Result: " + result1);
        System.out.println("\nSecond call (same input):");
        Object result2 = CacheExecutor.execute(service, "square", number);
        System.out.println("Result: " + result2);
    }
}
