// Base Class 
class Book {

    // Public variable
    // Accessible from anywhere
    public String ISBN;

    // Protected variable
    // Accessible within same package or subclass
    protected String title;

    // Private variable
    // Accessible only within this class
    private String author;

    // Parameterized constructor
    // Used to initialize book details
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public setter method
    // Used to modify private author name
    public void setAuthor(String author) {
        this.author = author;
    }

    // Public getter method
    // Used to access private author name
    public String getAuthor() {
        return author;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("ISBN   : " + ISBN);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("----------------------------");
    }
}

//  Subclass 
class EBook extends Book {

    // Constructor of subclass
    // Calls parent class constructor using super keyword
    EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    // Method to demonstrate access of public and protected members
    public void displayEBookDetails() {

        // Accessing public variable from parent class
        System.out.println("EBook ISBN  : " + ISBN);

        // Accessing protected variable from parent class
        System.out.println("EBook Title : " + title);

        // Accessing private variable using getter method
        System.out.println("EBook Author: " + getAuthor());

        System.out.println("----------------------------");
    }
}

//  Main Class 
public class BookLibrarySystem {

    public static void main(String[] args) {

        // Creating object of Book class
        Book book1 = new Book("978-0135166307", "Java Programming", "James Gosling");

        System.out.println("Book Details:");
        System.out.println();

        // Displaying book details
        book1.displayBookDetails();

        // Modifying author name using setter method
        book1.setAuthor("Oracle Java Team");

        System.out.println("After Updating Author:");
        System.out.println();

        // Displaying updated book details
        book1.displayBookDetails();

        // Creating object of EBook class
        EBook ebook1 = new EBook("978-0201633610", "Effective Java", "Joshua Bloch");

        System.out.println("EBook Details:");
        System.out.println();

        // Displaying ebook details
        ebook1.displayEBookDetails();
    }
}
