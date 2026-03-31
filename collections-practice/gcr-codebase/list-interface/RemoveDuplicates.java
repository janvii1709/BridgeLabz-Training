import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Set<Integer> set = new LinkedHashSet<>(list);
        List<Integer> result = new ArrayList<>(set);
        System.out.println("List after removing duplicates: " + result);
    }
}
