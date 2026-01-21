import java.util.Scanner;

public class MarketplaceMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Catalog catalog = new Catalog();

        while (true) {
            System.out.println("\n--- Online Marketplace Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Clothing");
            System.out.println("3. Add Gadget");
            System.out.println("4. Display All Products");
            System.out.println("5. Apply Discount");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> { // Add Book
                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Category (FICTION/NONFICTION/EDUCATIONAL/COMICS): ");
                    String cat = sc.nextLine().toUpperCase();
                    try {
                        BookCategory category = BookCategory.valueOf(cat);
                        Product<BookCategory> book = new Product<>(name, price, category);
                        catalog.addProduct(book);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid category! Book not added.");
                    }
                }
                case 2 -> { // Add Clothing
                    System.out.print("Enter Clothing Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Category (MEN/WOMEN/KIDS): ");
                    String cat = sc.nextLine().toUpperCase();
                    try {
                        ClothingCategory category = ClothingCategory.valueOf(cat);
                        Product<ClothingCategory> clothing = new Product<>(name, price, category);
                        catalog.addProduct(clothing);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid category! Clothing not added.");
                    }
                }
                case 3 -> { // Add Gadget
                    System.out.print("Enter Gadget Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Category (MOBILE/LAPTOP/ACCESSORY): ");
                    String cat = sc.nextLine().toUpperCase();
                    try {
                        GadgetCategory category = GadgetCategory.valueOf(cat);
                        Product<GadgetCategory> gadget = new Product<>(name, price, category);
                        catalog.addProduct(gadget);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid category! Gadget not added.");
                    }
                }
                case 4 -> catalog.displayAllProducts(); // Display products
                case 5 -> { // Apply discount
                    System.out.print("Enter Product Name to Discount: ");
                    String pname = sc.nextLine();
                    Product<?> found = null;
                    for (Product<?> p : catalog.getProducts()) {
                        if (p.getName().equalsIgnoreCase(pname)) {
                            found = p;
                            break;
                        }
                    }
                    if (found != null) {
                        System.out.print("Enter Discount Percentage: ");
                        double percent = sc.nextDouble();
                        sc.nextLine(); // Consume newline
                        Catalog.applyDiscount(found, percent);
                    } else {
                        System.out.println("Product not found!");
                    }
                }
                case 6 -> {
                    System.out.println("Exiting Marketplace...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
