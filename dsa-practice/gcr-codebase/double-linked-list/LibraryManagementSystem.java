import java.util.Scanner;

// Book node (Doubly Linked List)
class Book {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }
}

// Library class
class Library {
    private Book head;
    private Book tail;

    // Add book at beginning
    public void addBookAtBeginning(Book book) {
        if (head == null) {
            head = tail = book;
        } else {
            book.next = head;
            head.prev = book;
            head = book;
        }
        System.out.println("Book added at beginning");
    }

    // Add book at end
    public void addBookAtEnd(Book book) {
        if (tail == null) {
            head = tail = book;
        } else {
            tail.next = book;
            book.prev = tail;
            tail = book;
        }
        System.out.println("Book added at end");
    }

    // Add book at specific position
    public void addBookAtPosition(Book book, int position) {
        if (position <= 1) {
            addBookAtBeginning(book);
            return;
        }

        Book current = head;
        int index = 1;

        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null || current.next == null) {
            addBookAtEnd(book);
        } else {
            book.next = current.next;
            book.prev = current;
            current.next.prev = book;
            current.next = book;
            System.out.println("Book added at position " + position);
        }
    }

    // Remove book by ID
    public void removeBookById(int bookId) {
        Book current = head;

        while (current != null && current.bookId != bookId) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book ID not found");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        System.out.println("Book removed successfully");
    }

    // Search book by title or author
    public void searchBook(String keyword) {
        Book current = head;
        boolean found = false;

        while (current != null) {
            if (current.title.equalsIgnoreCase(keyword) ||
                current.author.equalsIgnoreCase(keyword)) {

                printBook(current);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No book found");
        }
    }

    // Update availability
    public void updateAvailability(int bookId, boolean status) {
        Book current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = status;
                System.out.println("Availability updated");
                return;
            }
            current = current.next;
        }
        System.out.println("Book ID not found");
    }

    // Display forward
    public void displayForward() {
        Book current = head;
        while (current != null) {
            printBook(current);
            current = current.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        Book current = tail;
        while (current != null) {
            printBook(current);
            current = current.prev;
        }
    }

    // Count books
    public int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Print book details
    private void printBook(Book b) {
        System.out.println(
                b.bookId + " | " + b.title + " | " + b.author +
                " | " + b.genre + " | Available: " + b.isAvailable
        );
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book");
            System.out.println("6. Update Availability");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Reverse");
            System.out.println("9. Count Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1, 2, 3 -> {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    boolean available = sc.nextBoolean();
                    sc.nextLine();

                    Book book = new Book(id, title, author, genre, available);

                    if (choice == 1)
                        library.addBookAtBeginning(book);
                    else if (choice == 2)
                        library.addBookAtEnd(book);
                    else {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        sc.nextLine();
                        library.addBookAtPosition(book, pos);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Book ID: ");
                    library.removeBookById(sc.nextInt());
                }
                case 5 -> {
                    System.out.print("Enter Title or Author: ");
                    library.searchBook(sc.nextLine());
                }
                case 6 -> {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter availability (true/false): ");
                    boolean status = sc.nextBoolean();
                    library.updateAvailability(id, status);
                }
                case 7 -> library.displayForward();
                case 8 -> library.displayReverse();
                case 9 -> System.out.println("Total Books: " + library.countBooks());
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
}
