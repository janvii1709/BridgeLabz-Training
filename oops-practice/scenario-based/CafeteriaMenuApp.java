import java.util.Scanner;

public class CafeteriaMenuApp {

    // Fixed cafeteria menu (10 items)
    static String[] menuItems = {
        "Aloo Sandwich",
        "Cheese Burger",
        "FarmHouse Pizza",
        "WhiteSaucePasta",
        "French Fries",
        "Cold Coffee",
        "Lemon Tea",
        "Cold Drink",
        "Ice Cream",
        "Chocolate Cake"
    };

    // Method to display menu
    public static void displayMenu() {
        System.out.println("----- Cafeteria Menu -----");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i + " : " + menuItems[i]);
        }
    }

    // Method to get item by index
    public static String getItemByIndex(int index) {
        if (index >= 0 && index < menuItems.length) {
            return menuItems[index];
        } else {
            return "Invalid Item";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Show menu
        displayMenu();

        // Ask how many items to order
        System.out.print("\nHow many items do you want to order : ");
        int count = sc.nextInt();

        // Array to store ordered items
        String[] orders = new String[count];

        // Take order by index
        for (int i = 0; i < count; i++) {
            System.out.print("Enter item index for order " + (i + 1) + ": ");
            int index = sc.nextInt();
            orders[i] = getItemByIndex(index);
        }

        // Display ordered items
        System.out.println("\n----- Your Order -----");
        for (int i = 0; i < orders.length; i++) {
            System.out.println((i + 1) + ". " + orders[i]);
        }
    }
}
