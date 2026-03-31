// Book class is used to store information about library books
class Book {
    // Library name is common for all books
    static String libraryName = "Egmore Library";
    // ISBN is unique and should not be changed
    final String isbn;
    // Book details (different for each book)
    String title;
    String author;
    // Constructor to assign book details
    // 'this' refers to the current book object
    Book(String title, String author, String isbn) {
        this.title = title;     // set book title
        this.author = author;   // set author name
        this.isbn = isbn;       // set ISBN number
    }
    // This method prints the library name
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    // This method displays book details
    // instanceof checks whether object belongs to Book class
    void displayDetails(Object obj) {
        if (obj instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }
}
// Main class for starting the execution of program
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create a book object
        Book book1 = new Book(
                "Effective Java",
                "Joshua Bloch",
                "978-0134685991"
        );
        // Display library name
        Book.displayLibraryName();
        // Display book details
        book1.displayDetails(book1);
    }
}
