import java.util.*;
public class ECommerceSorting {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 55000, 4.5, 10));
        products.add(new Product(2, "Mobile", 25000, 4.7, 20));
        products.add(new Product(3, "Headphones", 3000, 4.2, 30));
        // Sort by Price (Low -> High)
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("Sorted by Price:");
        products.forEach(System.out::println);
        // Sort by Rating (High ->  Low)
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("\nSorted by Rating:");
        products.forEach(System.out::println);
        // Sort by Discount (High ->  Low)
        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        System.out.println("\nSorted by Discount:");
        products.forEach(System.out::println);
    }
}
