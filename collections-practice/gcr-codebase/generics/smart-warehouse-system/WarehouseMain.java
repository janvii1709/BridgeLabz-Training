import java.util.Scanner;

public class WarehouseMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Storage<WarehouseItem> warehouse = new Storage<>();

        while (true) {
            System.out.println("\n1. Add Electronics\n2. Add Grocery\n3. Add Furniture\n4. Display All Items\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Electronics Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Warranty (months): ");
                    int warranty = sc.nextInt();
                    sc.nextLine();
                    warehouse.addItem(new Electronics(name, price, warranty));
                }
                case 2 -> {
                    System.out.print("Enter Grocery Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Expiry Date (dd-mm-yyyy): ");
                    String expiry = sc.nextLine();
                    warehouse.addItem(new Groceries(name, price, expiry));
                }
                case 3 -> {
                    System.out.print("Enter Furniture Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Material: ");
                    String material = sc.nextLine();
                    warehouse.addItem(new Furniture(name, price, material));
                }
                case 4 -> Storage.displayAllItems(warehouse.getItems());
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
