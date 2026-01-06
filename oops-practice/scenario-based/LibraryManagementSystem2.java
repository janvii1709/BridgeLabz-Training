import java.util.*;

// Custom Exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Book Class
class Book {
    String Title;
    String Author;
    boolean Available;

    Book(String Title, String Author, boolean Available) {
        this.Title = Title;
        this.Author = Author;
        this.Available = Available;
    }
}

// Library Utility Class
class Library {

    // Display all books
    static void DisplayBooks(List<Book> Books) {
        System.out.println("\n--- Library Books ---");
        for (Book b : Books) {
            System.out.println(
                "Title: " + b.Title +
                " | Author: " + b.Author +
                " | Status: " + (b.Available ? "Available" : "Checked Out")
            );
        }
    }

    // Search book by partial title
    static void SearchBook(List<Book> Books, String KeyWord) {
        boolean Found = false;
        System.out.println("\nSearch Results:");
        for (Book b : Books) {
            if (b.Title.toLowerCase().contains(KeyWord.toLowerCase())) {
                System.out.println("Title: " + b.Title + " | Author: " + b.Author);
                Found = true;
            }
        }
        if (!Found) {
            System.out.println("No book found.");
        }
    }

    // Checkout book (exact title)
    static void CheckoutBook(List<Book> Books, String Title)
            throws BookNotAvailableException {
        for (Book b : Books) {
            if (b.Title.equalsIgnoreCase(Title)) {
                if (!b.Available) {
                    throw new BookNotAvailableException("Book is already checked out!");
                }
                b.Available = false;
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found in library.");
    }
}

// Main Class
public class LibraryManagementSystem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ===== USER INPUT → ARRAY =====
        System.out.print("Enter number of books: ");
        int N = sc.nextInt();
        sc.nextLine(); // clear buffer
        Book[] BookArr = new Book[N];
        for (int i = 0; i < N; i++) {
            System.out.println("\nEnter details for Book " + (i + 1));

            System.out.print("Title: ");
            String Title = sc.nextLine();

            System.out.print("Author: ");
            String Author = sc.nextLine();

            // FIXED availability input
            System.out.print("Is available (Y/N): ");
            char C = sc.nextLine().toUpperCase().charAt(0);
            boolean Available = (C == 'Y');
            BookArr[i] = new Book(Title, Author, Available);
        }

        // ARRAY → LIST
        List<Book> Books = new ArrayList<>(Arrays.asList(BookArr));

        int choice;
        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Display Books");
            System.out.println("2. Search Book (Partial Title)");
            System.out.println("3. Checkout Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        Library.DisplayBooks(Books);
                        break;

                    case 2:
                        System.out.print("Enter partial title: ");
                        String keyword = sc.nextLine();
                        Library.SearchBook(Books, keyword);
                        break;

                    case 3:
                        System.out.print("Enter exact book title: ");
                        String checkoutTitle = sc.nextLine();
                        Library.CheckoutBook(Books, checkoutTitle);
                        break;

                    case 4:
                        System.out.println("Exiting Library System...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (BookNotAvailableException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 4);

    }
}
