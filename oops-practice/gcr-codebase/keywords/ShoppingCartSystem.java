// Product class holds details of items added to the shopping cart
class Product {
    // Discount is same for all products
    static double discount = 10.0;
    // Product ID should remain fixed, so it is final
    final String productID;
    // Product details (different for each product)
    String productName;
    double price;
    int quantity;
    // Constructor to assign product values
    // 'this' is used to refer to current product object
    Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;       // assign product ID
        this.productName = productName;   // assign product name
        this.price = price;               // assign product price
        this.quantity = quantity;         // assign product quantity
    }
    // This method updates discount for all products
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    // This method calculates price after discount
    double getDiscountedPrice() {
        return price - (price * discount / 100);
    }
    // This method prints product details
    // instanceof is used to make sure object is Product type
    void displayDetails(Object obj) {
        if (obj instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price after Discount: $" + getDiscountedPrice());
        }
    }
}
// Main class for starting the execution of program
public class ShoppingCartSystem {
    public static void main(String[] args) {
        // Creating first product
        Product product1 = new Product("P001", "Laptop", 1200.0, 5);
        // Creating second product
        Product product2 = new Product("P002", "Smartphone", 800.0, 10);
        // Display product information
        product1.displayDetails(product1);
        product2.displayDetails(product2);
    }
}
