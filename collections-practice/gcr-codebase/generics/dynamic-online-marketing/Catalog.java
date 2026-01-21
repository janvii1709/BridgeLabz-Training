import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Product<?>> products;

    public Catalog() {
        products = new ArrayList<>();
    }

    // Add a product
    public void addProduct(Product<?> product) {
        products.add(product);
        System.out.println(product.getName() + " added to catalog.");
    }

    // Display all products
    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in the catalog.");
            return;
        }
        for (Product<?> product : products) {
            product.displayDetails();
        }
    }

    // Apply discount
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(newPrice);
        System.out.println("Discount applied! New price of " + product.getName() + " is $" + newPrice);
    }

    // Getter for products
    public List<Product<?>> getProducts() {
        return products;
    }
}
