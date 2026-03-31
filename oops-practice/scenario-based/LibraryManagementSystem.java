import java.util.Scanner;

/*
 * LibraryManagementSystem class
 * This class manages book details and book checkout operations
 * using simple arrays and methods.
 */
class LibraryManagementSystem {

    // Array to store book titles
    static String[] titles;

    // Array to store book authors
    static String[] authors;

    // Array to store book status
    // true  -> Book is Available
    // false -> Book is Checked Out
    static boolean[] status;

    /*
     * Method: displayBooks()
     * Purpose: Display all books present in the library
     * along with their author names and current status.
     */
    public static void displayBooks() {
        System.out.println("\n----- List of Library Books -----");

        // Loop through all books
        for (int i = 0; i < titles.length; i++) {
            System.out.println(
                    (i + 1) + ". Title: " + titles[i]
                    + " | Author: " + authors[i]
                    + " | Status: " + (status[i] ? "Available" : "Checked Out")
            );
        }
    }

    /*
     * Method: searchBook()
     * Purpose: Search for a book using partial title.
     * The search is case-insensitive.
     */
    public static void searchBook(String keyword) {
        boolean found = false;

        System.out.println("\n----- Search Results -----");

        // Check each book title
        for (int i = 0; i < titles.length; i++) {

            // Convert both title and keyword to lowercase
            // to avoid case sensitivity issues
            if (titles[i].toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println(
                        (i + 1) + ". " + titles[i]
                        + " | Author: " + authors[i]
                        + " | Status: " + (status[i] ? "Available" : "Checked Out")
                );
                found = true;
            }
        }

        // If no matching book is found
        if (!found) {
            System.out.println("No book found with the given title.");
        }
    }

    /*
     * Method: checkoutBook()
     * Purpose: Change book status to Checked Out
     * if the book is currently available.
     */
    public static void checkoutBook(int index) {

        // Check if index is valid
        if (index >= 0 && index < titles.length) {

            // Check availability
            if (status[index]) {
                status[index] = false;
                System.out.println("Book checked out successfully.");
            } else {
                System.out.println("Book is already checked out.");
            }

        } else {
            System.out.println("Invalid book number.");
        }
    }

    /*
     * Method: returnBook()
     * Purpose: Change book status to Available
     * when a user returns the book.
     */
    public static void returnBook(int index) {

        // Validate index
        if (index >= 0 && index < titles.length) {

            if (!status[index]) {
                status[index] = true;
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Book is already available.");
            }

        } else {
            System.out.println("Invalid book number.");
        }
    }

    /*
     * Main method
     * Program execution starts from here.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask user how many books they want to store
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); // Clear input buffer

        // Initialize arrays based on user input
        titles = new String[n];
        authors = new String[n];
        status = new boolean[n];

        // Take book details from user
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Book " + (i + 1));

            System.out.print("Enter book title: ");
            titles[i] = sc.nextLine();

            System.out.print("Enter author name: ");
            authors[i] = sc.nextLine();

            // By default, every book is available
            status[i] = true;
        }

        int choice;

        // Menu-driven loop
        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Display All Books");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Check Out Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {

                case 1:
                    displayBooks();
                    break;

                case 2:
                    System.out.print("Enter partial title to search: ");
                    String keyword = sc.nextLine();
                    searchBook(keyword);
                    break;

                case 3:
                    System.out.print("Enter book number to check out: ");
                    checkoutBook(sc.nextInt() - 1);
                    break;

                case 4:
                    System.out.print("Enter book number to return: ");
                    returnBook(sc.nextInt() - 1);
                    break;

                case 5:
                    System.out.println("Thank you for using Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);
    }
}

