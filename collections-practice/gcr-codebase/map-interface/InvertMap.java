import java.util.*;
public class InvertMap {
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
        Map<Integer, List<String>> invertedMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            String key = entry.getKey();

            invertedMap.putIfAbsent(value, new ArrayList<>());
            invertedMap.get(value).add(key);
        }
        System.out.println("\nInverted Map: " + invertedMap);
    }
}
