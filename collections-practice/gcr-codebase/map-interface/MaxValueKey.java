import java.util.*;
public class MaxValueKey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        System.out.print("Enter number of entries in the map: ");
        int n = sc.nextInt();
        System.out.println("Enter entries (key value):");
        for (int i = 0; i < n; i++) {
            String key = sc.next();
            int value = sc.nextInt();
            map.put(key, value);
        }
        if (map.isEmpty()) {
            System.out.println("Map is empty.");
            return;
        }
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println("Key with the highest value: " + maxKey);
    }
}
