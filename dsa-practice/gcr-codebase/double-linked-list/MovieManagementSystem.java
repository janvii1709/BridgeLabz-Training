import java.util.Scanner;

public class MovieManagementSystem {

    // Movie node for Doubly Linked List
    static class Movie {
        String title;      // Movie title
        String director;   // Director name
        int year;          // Year of release
        double rating;     // Movie rating

        Movie next;        // Pointer to next node
        Movie prev;        // Pointer to previous node
    }

    // Head and Tail of the doubly linked list
    static Movie head = null;
    static Movie tail = null;

    // ADD AT BEGINNING 
    static void addAtBeginning(String t, String d, int y, double r) {
        Movie newMovie = new Movie();
        newMovie.title = t;
        newMovie.director = d;
        newMovie.year = y;
        newMovie.rating = r;

        newMovie.next = head;
        newMovie.prev = null;

        if (head != null) {
            head.prev = newMovie;
        } else {
            tail = newMovie; // first node
        }

        head = newMovie;
        System.out.println("Movie added successfully");
    }

    // ADD AT END
    static void addAtEnd(String t, String d, int y, double r) {
        Movie newMovie = new Movie();
        newMovie.title = t;
        newMovie.director = d;
        newMovie.year = y;
        newMovie.rating = r;

        newMovie.next = null;
        newMovie.prev = tail;

        if (tail != null) {
            tail.next = newMovie;
        } else {
            head = newMovie; // first node
        }

        tail = newMovie;
        System.out.println("Movie added successfully");
    }

    //  ADD AT SPECIFIC POSITION 
    static void addAtPosition(int pos, String t, String d, int y, double r) {

        if (pos == 1) {
            addAtBeginning(t, d, y, r);
            return;
        }

        Movie temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(t, d, y, r);
            return;
        }

        Movie newMovie = new Movie();
        newMovie.title = t;
        newMovie.director = d;
        newMovie.year = y;
        newMovie.rating = r;

        newMovie.next = temp.next;
        newMovie.prev = temp;

        temp.next.prev = newMovie;
        temp.next = newMovie;

        System.out.println("Movie added successfully");
    }

    //  DELETE BY MOVIE TITLE 
    static void deleteByTitle(String t) {

        if (head == null) {
            System.out.println("No movie records found");
            return;
        }

        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(t)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie deleted successfully");
    }

    //  SEARCH BY DIRECTOR 
    static void searchByDirector(String d) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(d)) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movie found for this director");
    }

    //  SEARCH BY RATING 
    static void searchByRating(double r) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == r) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movie found with this rating");
    }

    //  UPDATE RATING 
    static void updateRating(String t, double r) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(t)) {
                temp.rating = r;
                System.out.println("Rating updated successfully");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    // DISPLAY FORWARD 
    static void displayForward() {

        if (head == null) {
            System.out.println("No movie records found");
            return;
        }

        Movie temp = head;
        System.out.println("Movies (Forward Order):");

        while (temp != null) {
            printMovie(temp);
            temp = temp.next;
        }
    }

    //  DISPLAY REVERSE 
    static void displayReverse() {

        if (tail == null) {
            System.out.println("No movie records found");
            return;
        }

        Movie temp = tail;
        System.out.println("Movies (Reverse Order):");

        while (temp != null) {
            printMovie(temp);
            temp = temp.prev;
        }
    }

    //  PRINT MOVIE DETAILS 
    static void printMovie(Movie m) {
        System.out.println("Title: " + m.title);
        System.out.println("Director: " + m.director);
        System.out.println("Year: " + m.year);
        System.out.println("Rating: " + m.rating);
        System.out.println("---------------------------");
    }

    // MAIN METHOD 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Specific Position");
            System.out.println("4. Delete by Movie Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                case 2:
                case 3:
                    if (choice == 3) {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Title: ");
                        String t = sc.nextLine();
                        System.out.print("Enter Director: ");
                        String d = sc.nextLine();
                        System.out.print("Enter Year: ");
                        int y = sc.nextInt();
                        System.out.print("Enter Rating: ");
                        double r = sc.nextDouble();
                        addAtPosition(pos, t, d, y, r);
                        break;
                    }

                    System.out.print("Enter Title: ");
                    String t = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String d = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int y = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double r = sc.nextDouble();

                    if (choice == 1)
                        addAtBeginning(t, d, y, r);
                    else
                        addAtEnd(t, d, y, r);
                    break;

                case 4:
                    System.out.print("Enter Movie Title to delete: ");
                    deleteByTitle(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Director name: ");
                    searchByDirector(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter Rating: ");
                    searchByRating(sc.nextDouble());
                    break;

                case 7:
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    double newRating = sc.nextDouble();
                    updateRating(title, newRating);
                    break;

                case 8:
                    displayForward();
                    break;

                case 9:
                    displayReverse();
                    break;

                case 10:
                    System.out.println("Exiting the program");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 10);
    }
}
