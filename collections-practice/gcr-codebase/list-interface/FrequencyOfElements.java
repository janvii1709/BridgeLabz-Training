import java.util.*;
public class FrequencyOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        Map<String, Integer> frequencyMap = new HashMap<>();
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
        for (String item : list) {
            if (frequencyMap.containsKey(item)) {
                frequencyMap.put(item, frequencyMap.get(item) + 1);
            } else {
                frequencyMap.put(item, 1);
            }
        }

        System.out.println("Frequency Map: " + frequencyMap);
    }
}
