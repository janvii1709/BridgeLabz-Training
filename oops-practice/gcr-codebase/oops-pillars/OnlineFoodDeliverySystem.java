import java.util.*;
//Interface
// This interface is for food items on which discount can be applied
interface Discountable {
    double applyDiscount();          // Calculates discount amount
    String getDiscountDetails();     // Returns discount description
}
//Abstract Class
// Parent class for all food items
abstract class FoodItem {
    // Private variables to protect data (Encapsulation)
    private String itemName;
    private double price;
    private int quantity;
    // Constructor to initialize food item details
    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    // Getters (read-only access)
    public String getItemName() {
        return itemName;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : " + price);
        System.out.println("Quantity  : " + quantity);
    }
    // Abstract method to calculate total price
    abstract double calculateTotalPrice();
}
// Veg Item Class
class VegItem extends FoodItem implements Discountable {
    VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    // Total price calculation for veg item
    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
    // 10% discount on veg items
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }
    public String getDiscountDetails() {
        return "10% discount on Veg Items";
    }
}
//Non-Veg Item Class
class NonVegItem extends FoodItem implements Discountable {

    NonVegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    // Total price calculation with extra non-veg charge
    double calculateTotalPrice() {
        double basePrice = getPrice() * getQuantity();
        double extraCharge = basePrice * 0.05; // 5% extra charge
        return basePrice + extraCharge;
    }

    // 5% discount on non-veg items
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    public String getDiscountDetails() {
        return "5% discount on Non-Veg Items";
    }
}

//Main Class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ArrayList to store multiple food items
        ArrayList<FoodItem> order = new ArrayList<>();

        System.out.print("Enter number of food items: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Taking input for each food item
        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter details for food item " + i);

            // Item name 
            String name;
            while (true) {
                System.out.print("Item Name : ");
                name = sc.nextLine();
                if (name.matches("[a-zA-Z ]+"))
                    break;
                System.out.println(" Item name must contain only alphabets");
            }

            // Price
            double price;
            while (true) {
                System.out.print("Price: ");
                if (sc.hasNextDouble()) {
                    price = sc.nextDouble();
                    break;
                } else {
                    System.out.println("Price must be numeric");
                    sc.next();
                }
            }

            // Quantity 
            int quantity;
            while (true) {
                System.out.print("Quantity: ");
                if (sc.hasNextInt()) {
                    quantity = sc.nextInt();
                    break;
                } else {
                    System.out.println("Quantity must be numeric");
                    sc.next();
                }
            }

            // Food type selection
            int type;
            while (true) {
                System.out.println("Food Type:");
                System.out.println("1. Veg");
                System.out.println("2. Non-Veg");
                type = sc.nextInt();

                if (type == 1 || type == 2)
                    break;
                System.out.println("Invalid choice! Enter 1 or 2");
            }
            sc.nextLine();

            // Polymorphism: parent reference, child object
            FoodItem item;
            if (type == 1)
                item = new VegItem(name, price, quantity);
            else
                item = new NonVegItem(name, price, quantity);

            order.add(item);
        }

        //Order Summary
        System.out.println("\n----- Order Summary -----");

        double grandTotal = 0;

        // Polymorphism in action
        for (FoodItem item : order) {

            item.getItemDetails();
            double total = item.calculateTotalPrice();

            Discountable d = (Discountable) item;
            double discount = d.applyDiscount();

            System.out.println("Total Price    : " + total);
            System.out.println("Discount       : " + discount);
            System.out.println(d.getDiscountDetails());
            System.out.println("Final Amount   : " + (total - discount));
            System.out.println("-------------------------------------------------------------------");

            grandTotal += (total - discount);
        }

        System.out.println("Grand Total Amount: " + grandTotal);
    }
}
