import java.util.*;
public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> productPrices = new HashMap<>();
        LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter product name: ");
            String product = sc.next();
            System.out.print("Enter product price: ");
            int price = sc.nextInt();
            productPrices.put(product, price);
            cart.put(product, price);
        }
        System.out.println("\nItems in Cart (Insertion Order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        TreeMap<Integer, List<String>> sortedByPrice = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            int price = entry.getValue();
            String product = entry.getKey();
            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(product);
        }
        System.out.println("\nItems Sorted by Price:");
        for (Map.Entry<Integer, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " : " + entry.getKey());
            }
        }
    }
}
