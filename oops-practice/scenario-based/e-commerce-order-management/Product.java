public class Product {
    private int productId;
    private String name;
    private double price;
    private int quantity;   // available stock

    public Product(int productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int qty) {
        quantity -= qty;
    }

    public void display() {
        System.out.println(productId + " | " + name + " | INR " + price + " | Stock: " + quantity);
    }
}
