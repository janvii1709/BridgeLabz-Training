import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully");
    }

    public Product findProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
