import java.util.*;
public class SubsetCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        System.out.print("Enter number of elements in Set1: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements for Set1:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }
        System.out.print("Enter number of elements in Set2: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements for Set2:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }
        boolean isSubset = set2.containsAll(set1);
        System.out.println("Is Set1 a subset of Set2? " + isSubset);
    }
}
