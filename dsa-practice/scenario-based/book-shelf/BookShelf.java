import java.util.*;
public class BookShelf {
    static HashMap<String, LinkedList<Book>> library = new HashMap<>();
    static HashSet<String> isbnSet = new HashSet<>();
    static Scanner sc = new Scanner(System.in);
    // Add Book (Return Book)
    static void addBook() {

        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        if (isbnSet.contains(isbn)) {
            System.out.println("Book already exists!");
            return;
        }

        Book book = new Book(title, author, isbn);

        library.putIfAbsent(genre, new LinkedList<>());
        library.get(genre).add(book);

        isbnSet.add(isbn);
        System.out.println("Book added successfully!");
    }

    // Borrow Book
    static void borrowBook() {

        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();

        if (!library.containsKey(genre)) {
            System.out.println("Genre not found!");
            return;
        }

        System.out.print("Enter ISBN to Borrow: ");
        String isbn = sc.nextLine();

        LinkedList<Book> books = library.get(genre);
        Iterator<Book> it = books.iterator();

        while (it.hasNext()) {
            Book b = it.next();
            if (b.isbn.equals(isbn)) {
                it.remove();
                isbnSet.remove(isbn);
                System.out.println("Book borrowed successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Display Library
    static void displayLibrary() {
        if (library.isEmpty()) {
            System.out.println("Library is empty!");
            return;
        }

        for (String genre : library.keySet()) {
            System.out.println("\nGenre: " + genre);
            for (Book b : library.get(genre)) {
                System.out.println("  - " + b);
            }
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n BookShelf Library Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Display Library");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addBook();
                case 2 -> borrowBook();
                case 3 -> displayLibrary();
                case 4 -> {
                    System.out.println("Thank you for using Library System!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
