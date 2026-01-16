import java.util.Scanner;

public class MovieManagementSystem {

    // Movie node for Doubly Linked List
    static class Movie {
        String title;
        String director;
        int year;
        double rating;
        Movie next;
        Movie prev;
    }

    // Head and Tail pointers
    static Movie head = null;
    static Movie tail = null;

    // ADD MOVIE AT BEGINNING
    static void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie movie = new Movie();
        movie.title = title;
        movie.director = director;
        movie.year = year;
        movie.rating = rating;

        movie.next = head;
        movie.prev = null;

        if (head != null) {
            head.prev = movie;
        } else {
            tail = movie;
        }
        head = movie;
        System.out.println("Movie added successfully");
    }

    // ADD MOVIE AT END
    static void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie movie = new Movie();
        movie.title = title;
        movie.director = director;
        movie.year = year;
        movie.rating = rating;

        movie.next = null;
        movie.prev = tail;

        if (tail != null) {
            tail.next = movie;
        } else {
            head = movie;
        }
        tail = movie;
        System.out.println("Movie added successfully");
    }

    // ADD MOVIE AT SPECIFIC POSITION
    static void addMovieAtPosition(int position, String title, String director, int year, double rating) {

        if (position == 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        Movie temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addMovieAtEnd(title, director, year, rating);
            return;
        }

        Movie movie = new Movie();
        movie.title = title;
        movie.director = director;
        movie.year = year;
        movie.rating = rating;

        movie.next = temp.next;
        movie.prev = temp;
        temp.next.prev = movie;
        temp.next = movie;

        System.out.println("Movie added successfully");
    }

    // DELETE MOVIE BY TITLE
    static void deleteMovieByTitle(String title) {

        if (head == null) {
            System.out.println("No movie records found");
            return;
        }

        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie deleted successfully");
    }

    // SEARCH MOVIE BY DIRECTOR
    static void searchMovieByDirector(String director) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movie found for this director");
        }
    }

    // SEARCH MOVIE BY RATING
    static void searchMovieByRating(double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movie found with this rating");
        }
    }

    // UPDATE MOVIE RATING
    static void updateMovieRating(String title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    // DISPLAY MOVIES FORWARD
    static void displayForward() {
        if (head == null) {
            System.out.println("No movie records found");
            return;
        }

        Movie temp = head;
        while (temp != null) {
            printMovie(temp);
            temp = temp.next;
        }
    }

    // DISPLAY MOVIES REVERSE
    static void displayReverse() {
        if (tail == null) {
            System.out.println("No movie records found");
            return;
        }

        Movie temp = tail;
        while (temp != null) {
            printMovie(temp);
            temp = temp.prev;
        }
    }

    // PRINT MOVIE DETAILS
    static void printMovie(Movie movie) {
        System.out.println("Title: " + movie.title);
        System.out.println("Director: " + movie.director);
        System.out.println("Year: " + movie.year);
        System.out.println("Rating: " + movie.rating);
        System.out.println("---------------------------");
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Update Rating");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1, 2, 3 -> {
                    if (choice == 3) {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Director: ");
                        String director = sc.nextLine();
                        System.out.print("Enter Year: ");
                        int year = sc.nextInt();
                        System.out.print("Enter Rating: ");
                        double rating = sc.nextDouble();
                        addMovieAtPosition(pos, title, director, year, rating);
                        break;
                    }

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = sc.nextDouble();

                    if (choice == 1)
                        addMovieAtBeginning(title, director, year, rating);
                    else
                        addMovieAtEnd(title, director, year, rating);
                }

                case 4 -> {
                    System.out.print("Enter Movie Title: ");
                    deleteMovieByTitle(sc.nextLine());
                }

                case 5 -> {
                    System.out.print("Enter Director Name: ");
                    searchMovieByDirector(sc.nextLine());
                }

                case 6 -> {
                    System.out.print("Enter Rating: ");
                    searchMovieByRating(sc.nextDouble());
                }

                case 7 -> {
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    double newRating = sc.nextDouble();
                    updateMovieRating(title, newRating);
                }

                case 8 -> displayForward();
                case 9 -> displayReverse();
                case 10 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice");
            }

        } while (choice != 10);

    }
}
