public class LibraryBook {
    String title;
    String author;
    double price;
    boolean availability;
    // Parameterized constructor
    LibraryBook(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    // Method to borrow a book
    void BorrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Sorry, book is not available.");
        }
    }

    // Method to display book details
    void Display() {
        System.out.println("Title        : " + title);
        System.out.println("Author       : " + author);
        System.out.println("Price        : " + price);
        System.out.println("Availability : " + availability);
        System.out.println("-------------------------------");
    }

    // Main method
    public static void main(String[] args) {
        LibraryBook Book1 = new LibraryBook("Java Programming", "James Gosling", 500.0, true);
        Book1.Display();
        Book1.BorrowBook();
        Book1.Display();
    }
}
