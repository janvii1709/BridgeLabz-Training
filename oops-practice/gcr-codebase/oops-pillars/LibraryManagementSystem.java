import java.util.*;
//Interface
// This interface is used for items that can be reserved
interface Reservable {
    void reserveItem();          // Method to reserve the item
    boolean checkAvailability(); // Method to check if item is available
}
//Abstract Class
// This is the parent class for all library items
abstract class LibraryItem {
    // Private variables to protect data (Encapsulation)
    private int itemId;
    private String title;
    private String author;
    private boolean available = true;
    // Constructor to initialize common item details
    LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    // Getter to check availability of item
    public boolean isAvailable() {
        return available;
    }
    // Protected setter so only child classes can update availability
    protected void setAvailable(boolean status) {
        available = status;
    }
    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }
    // Abstract method to be implemented by child classes
    abstract int getLoanDuration();
}
//Book Class
// Book class extends LibraryItem and implements Reservable interface
class Book extends LibraryItem implements Reservable {

    Book(int id, String title, String author) {
        super(id, title, author);
    }
    // Book can be issued for 14 days
    int getLoanDuration() {
        return 14;
    }
    // Reserve book if available
    public void reserveItem() {
        if (checkAvailability()) {
            setAvailable(false);
            System.out.println("Book reserved successfully");
        }
    }
    // Check if book is available
    public boolean checkAvailability() {
        return isAvailable();
    }
}
//Magazine Class
class Magazine extends LibraryItem implements Reservable {
    Magazine(int id, String title, String author) {
        super(id, title, author);
    }
    // Magazine can be issued for 7 days
    int getLoanDuration() {
        return 7;
    }
    // Reserve magazine if available
    public void reserveItem() {
        if (checkAvailability()) {
            setAvailable(false);
            System.out.println("Magazine reserved successfully");
        }
    }
    public boolean checkAvailability() {
        return isAvailable();
    }
}
//  DVD Class
class DVD extends LibraryItem implements Reservable {

    DVD(int id, String title, String author) {
        super(id, title, author);
    }

    // DVD can be issued for 3 days
    int getLoanDuration() {
        return 3;
    }

    // Reserve DVD if available
    public void reserveItem() {
        if (checkAvailability()) {
            setAvailable(false);
            System.out.println("DVD reserved successfully");
        }
    }

    public boolean checkAvailability() {
        return isAvailable();
    }
}

//Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ArrayList is used to store multiple library items
        ArrayList<LibraryItem> items = new ArrayList<>();

        System.out.print("Enter number of library items: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Loop to take input for each library item
        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter details for item " + i);

            // Item ID validation 
            int id;
            while (true) {
                System.out.print("Item ID : ");
                if (sc.hasNextInt()) {
                    id = sc.nextInt();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println(" Item ID must contain only numbers");
                    sc.next();
                }
            }

            // Title validation 
            String title;
            while (true) {
                System.out.print("Title : ");
                title = sc.nextLine();
                if (title.matches("[a-zA-Z ]+"))
                    break;
                System.out.println("Title must contain only alphabets");
            }

            // Author validation 
            String author;
            while (true) {
                System.out.print("Author : ");
                author = sc.nextLine();
                if (author.matches("[a-zA-Z ]+"))
                    break;
                System.out.println(" Author must contain only alphabets");
            }

            // Item type selection with validation
            int type;
            while (true) {
                System.out.println("Item Type:");
                System.out.println("1. Book");
                System.out.println("2. Magazine");
                System.out.println("3. DVD");
                type = sc.nextInt();

                if (type >= 1 && type <= 3)
                    break;
                System.out.println("Invalid choice! Enter 1, 2, or 3");
            }
            sc.nextLine();

            // Polymorphism: parent reference holding child object
            LibraryItem item;
            if (type == 1)
                item = new Book(id, title, author);
            else if (type == 2)
                item = new Magazine(id, title, author);
            else
                item = new DVD(id, title, author);

            items.add(item);
        }

        // Display all library items
        System.out.println("\n----- Library Items Summary -----");

        // Polymorphism in action
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            // Interface reference
            ((Reservable) item).reserveItem();
            System.out.println("-------------------------------");
        }
    }
}
