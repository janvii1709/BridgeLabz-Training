public class Product {
    // Instance variables (each object has its own copy)
    String productName;
    double price;
    // Class variable (shared by all objects)
    static int totalProducts = 0;
    // Parameterized constructor
    // This constructor initializes product details
    // and increases total product count
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;   // increment when a new product is created
    }
    // Instance method
    // Displays details of a single product
    void DisplayProductDetails() {
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : INR " + price);
        System.out.println("-------------------------");
    }
    // Class (static) method
    // Displays total number of products created
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
    // Main method
    public static void main(String[] args) {
        // Creating product objects
        Product product1 = new Product("Laptop", 55000);
        Product product2 = new Product("Mobile", 20000);
        Product product3 = new Product("Headphones", 3000);
        // Display individual product details
        product1.DisplayProductDetails();
        product2.DisplayProductDetails();
        product3.DisplayProductDetails();
        // Display total number of products
        Product.displayTotalProducts();
    }
}
