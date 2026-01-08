import java.util.Scanner;

class Book {
    int bookID;
    String title;
    String author;
    String genre;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(int bookID, String title, String author, String genre, boolean isAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head;
    private Book tail;

    public Library() {
        head = null;
        tail = null;
    }

    // Add book at the beginning
    public void addBookAtBeginning(Book newBook) {
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        System.out.println("Book added at the beginning: " + newBook.title);
    }

    // Add book at the end
    public void addBookAtEnd(Book newBook) {
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        System.out.println("Book added at the end: " + newBook.title);
    }

    // Add book at specific position
    public void addBookAtPosition(Book newBook, int position) {
        if (position <= 1) {
            addBookAtBeginning(newBook);
            return;
        }

        Book current = head;
        int index = 1;
        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null || current.next == null) {
            addBookAtEnd(newBook);
        } else {
            newBook.next = current.next;
            newBook.prev = current;
            current.next.prev = newBook;
            current.next = newBook;
            System.out.println("Book added at position " + position + ": " + newBook.title);
        }
    }

    // Remove book by ID
    public void removeBookByID(int bookID) {
        Book current = head;

        while (current != null && current.bookID != bookID) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book ID not found: " + bookID);
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

        System.out.println("Book removed: " + current.title);
    }

    // Search book by title or author
    public void searchBook(String keyword) {
        Book current = head;
        boolean found = false;

        while (current != null) {
            if (current.title.equalsIgnoreCase(keyword) || current.author.equalsIgnoreCase(keyword)) {
                System.out.println("Found Book: " + current.bookID + " | " + current.title + " | " + current.author + " | " + current.genre + " | Available: " + current.isAvailable);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No book found with keyword: " + keyword);
        }
    }

    // Update availability
    public void updateAvailability(int bookID, boolean status) {
        Book current = head;

        while (current != null) {
            if (current.bookID == bookID) {
                current.isAvailable = status;
                System.out.println("Updated availability for " + current.title + " to " + status);
                return;
            }
            current = current.next;
        }

        System.out.println("Book ID not found: " + bookID);
    }

    // Display books forward
    public void displayForward() {
        Book current = head;
        System.out.println("Books in library (Forward):");
        while (current != null) {
            System.out.println(current.bookID + " | " + current.title + " | " + current.author + " | " + current.genre + " | Available: " + current.isAvailable);
            current = current.next;
        }
    }

    // Display books reverse
    public void displayReverse() {
        Book current = tail;
        System.out.println("Books in library (Reverse):");
        while (current != null) {
            System.out.println(current.bookID + " | " + current.title + " | " + current.author + " | " + current.genre + " | Available: " + current.isAvailable);
            current = current.prev;
        }
    }

    // Count total books
    public int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

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
            System.out.println("5. Search Book by Title/Author");
            System.out.println("6. Update Availability");
            System.out.println("7. Display Books Forward");
            System.out.println("8. Display Books Reverse");
            System.out.println("9. Count Total Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

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
                    System.out.print("Is Available? (true/false): ");
                    boolean available = sc.nextBoolean();
                    sc.nextLine();

                    Book book = new Book(id, title, author, genre, available);

                    if (choice == 1) library.addBookAtBeginning(book);
                    else if (choice == 2) library.addBookAtEnd(book);
                    else {
                        System.out.print("Enter position to insert: ");
                        int pos = sc.nextInt();
                        sc.nextLine();
                        library.addBookAtPosition(book, pos);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Book ID to remove: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    library.removeBookByID(id);
                }
                case 5 -> {
                    System.out.print("Enter Title or Author to search: ");
                    String keyword = sc.nextLine();
                    library.searchBook(keyword);
                }
                case 6 -> {
                    System.out.print("Enter Book ID to update availability: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new availability (true/false): ");
                    boolean available = sc.nextBoolean();
                    sc.nextLine();
                    library.updateAvailability(id, available);
                }
                case 7 -> library.displayForward();
                case 8 -> library.displayReverse();
                case 9 -> System.out.println("Total Books: " + library.countBooks());
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

    }
}
