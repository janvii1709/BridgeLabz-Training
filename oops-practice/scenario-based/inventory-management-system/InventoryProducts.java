import java.util.Scanner;

public class InventoryProducts {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Display Products");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1: // Add Product
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Stock: ");
                    int stock = sc.nextInt();

                    inventory.addProduct(new Product(id, name, stock));
                    break;

                case 2: // Update Stock (Add / Reduce + Low Stock Alert)
                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt();

                    Product product = inventory.findProduct(pid);
                    if (product == null) {
                        System.out.println("Product not found");
                        break;
                    }

                    System.out.println("1. Add Stock");
                    System.out.println("2. Reduce Stock");
                    System.out.print("Enter your choice: ");
                    int updateChoice = sc.nextInt();

                    if (updateChoice == 1) {
                        System.out.print("Enter quantity to add: ");
                        int qty = sc.nextInt();
                        product.addStock(qty);
                        System.out.println("Stock added successfully");
                    }
                    else if (updateChoice == 2) {
                        System.out.print("Enter quantity to reduce: ");
                        int qty = sc.nextInt();
                        product.reduceStock(qty);
                    }
                    else {
                        System.out.println("Invalid choice");
                        break;
                    }

                    //  Low Stock Alert
                    System.out.print("Enter low stock alert limit: ");
                    int limit = sc.nextInt();

                    if (product.getStock() <= limit) {
                        System.out.println(
                            " LOW STOCK ALERT: " +
                            product.getName() +
                            " | Stock: " +
                            product.getStock()
                        );
                    }
                    break;

                case 3: // Display Products
                    if (inventory.getProducts().isEmpty()) {
                        System.out.println("No products available");
                        break;
                    }

                    System.out.println("\n--- Product List ---");
                    for (Product p : inventory.getProducts()) {
                        System.out.println(
                            p.getId() + " | " +
                            p.getName() + " | Stock: " +
                            p.getStock()
                        );
                    }
                    break;

                case 4:
                    System.out.println("Exiting system");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
