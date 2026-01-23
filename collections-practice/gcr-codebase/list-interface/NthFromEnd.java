import java.util.*;
public class NthFromEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        System.out.print("Enter number of elements: ");
        int size = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            list.add(sc.nextLine());
        }
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();
        for (int i = 0; i < n; i++) {
            if (fast.hasNext()) {
                fast.next();
            } else {
                System.out.println("N is larger than list size");
                return;
            }
        }
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }
        System.out.println("Nth element from end: " + slow.next());
    }
}
