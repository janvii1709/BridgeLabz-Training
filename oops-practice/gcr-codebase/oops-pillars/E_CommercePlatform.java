import java.util.*;

//ABSTRACT CLASS
abstract class Product {

    // Encapsulated fields
    private int productId;
    private String name;
    protected double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method
    public abstract double calculateDiscount();

    // Concrete method
    public void displayDetails() {
        System.out.println("Product ID  : " + productId);
        System.out.println("Name        : " + name);
        System.out.println("Price       : " + price);
    }

    // Getter & Setter
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

//INTERFACE
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// ELECTRONICS
class Electronics extends Product implements Taxable {

    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return price * 0.10;   // 10% discount
    }

    public double calculateTax() {
        return price * 0.18;   // 18% GST
    }

    public String getTaxDetails() {
        return "18% GST on Electronics";
    }
}

// ================= CLOTHING =================
class Clothing extends Product implements Taxable {

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return price * 0.20;   // 20% discount
    }

    public double calculateTax() {
        return price * 0.05;   // 5% GST
    }

    public String getTaxDetails() {
        return "5% GST on Clothing";
    }
}

// GROCERIES
class Groceries extends Product {

    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return price * 0.05;   // 5% discount
    }
}

//MAIN CLASS
public class E_CommercePlatform {

    //Validation Methods
    static int getNumericInt(Scanner sc, String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
        } while (!input.matches("[0-9]+"));
        return Integer.parseInt(input);
    }

    static double getNumericDouble(Scanner sc, String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
        } while (!input.matches("[0-9]+"));
        return Double.parseDouble(input);
    }

    static String getAlphabetic(Scanner sc, String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
        } while (!input.matches("[a-zA-Z]+"));
        return input;
    }

    //Polymorphic Method
    static void calculateFinalPrice(List<Product> products) {

        for (Product p : products) {

            p.displayDetails();

            double tax = 0;
            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                tax = t.calculateTax();
                System.out.println("Tax Details : " + t.getTaxDetails());
            }

            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;

            System.out.println("Discount    : " + discount);
            System.out.println("Final Price : " + finalPrice);
            System.out.println("-------------------------------");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nProduct " + i);
            System.out.println("1. Electronics");
            System.out.println("2. Clothing");
            System.out.println("3. Groceries");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            int id = getNumericInt(sc, "Product ID : ");
            String name = getAlphabetic(sc, "Product Name : ");
            double price = getNumericDouble(sc, "Price : ");

            if (choice == 1) {
                products.add(new Electronics(id, name, price));
            }
            else if (choice == 2) {
                products.add(new Clothing(id, name, price));
            }
            else if (choice == 3) {
                products.add(new Groceries(id, name, price));
            }
            else {
                System.out.println("Invalid choice!");
                i--;
            }
        }

        System.out.println("\n---------------- FINAL PRICE DETAILS ---------------- ");
        calculateFinalPrice(products);

    }
}
