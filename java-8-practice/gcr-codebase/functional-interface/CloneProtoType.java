import java.util.Scanner;
class Product implements Cloneable {
    String productName;
    double price;
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    void display() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: INR " + price);
    }
}
public class CloneProtoType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter product price: ");
        double price = sc.nextDouble();

        try {
            Product original = new Product(name, price);
            Product cloned = (Product) original.clone();
            System.out.println("\nOriginal Object:");
            original.display();
            System.out.println("\nCloned Object:");
            cloned.display();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported.");
        }
    }
}
