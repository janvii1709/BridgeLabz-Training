import java.util.*;
public class Compare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking user input for dataset size
        System.out.print("Enter the dataset size (N): ");
        int n = sc.nextInt();

        // Creating dataset
        List<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            arrayList.add(i);
            hashSet.add(i);
            treeSet.add(i);
        }

        // Element to search (last element to simulate worst-case for array)
        int target = n - 1;

        // Array (Linear Search)
        long start = System.nanoTime();
        boolean foundArray = arrayList.contains(target);
        long end = System.nanoTime();
        System.out.printf("Array Search: %.5f ms\n", (end - start) / 1_000_000.0);

        // HashSet (O(1) average)
        start = System.nanoTime();
        boolean foundHashSet = hashSet.contains(target);
        end = System.nanoTime();
        System.out.printf("HashSet Search: %.5f ms\n", (end - start) / 1_000_000.0);

        // TreeSet (O(log N))
        start = System.nanoTime();
        boolean foundTreeSet = treeSet.contains(target);
        end = System.nanoTime();
        System.out.printf("TreeSet Search: %.5f ms\n", (end - start) / 1_000_000.0);

        // Output of the following
        System.out.println("\nExpected Result:");
        System.out.println("HashSet is fastest for lookups but requires extra memory.");
        System.out.println("TreeSet maintains order but is slightly slower than HashSet.");
        System.out.println("Array is simple but slow for large datasets.");
    }
}
