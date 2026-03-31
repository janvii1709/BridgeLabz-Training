public class Book {
    // Attributes
    String title;
    String author;
    double price;
    // Default constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }
    // Parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    // Method to display book details
    void Display() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : INR " + price);
        // System.out.println("---------------------");
    }

    // Main method
    public static void main(String[] args) {

        // Object using default constructor
        Book book1 = new Book();
        System.out.println("These are details of the book using default constructor");
        System.out.println(); // For extra line
        book1.Display();

        System.out.println("-------------------------------------------------------------");

        // Object using parameterized constructor
        Book book2 = new Book("Java Programming", "James Gosling", 550.00);
        System.out.println(); // For extra line
        System.out.println("These are details of the book using parameterized constructor");
        book2.Display();
    }
}
