import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Rotate by positions: ");
        int k = sc.nextInt();

        k = k % list.size(); // handle k > size

        List<Integer> temp = new ArrayList<>();

        // Store first k elements
        for (int i = 0; i < k; i++) {
            temp.add(list.get(i));
        }

        // Shift remaining elements
        for (int i = k; i < list.size(); i++) {
            list.set(i - k, list.get(i));
        }

        // Add stored elements at end
        for (int i = 0; i < temp.size(); i++) {
            list.set(list.size() - k + i, temp.get(i));
        }

        System.out.println("Rotated List: " + list);
    }
}
