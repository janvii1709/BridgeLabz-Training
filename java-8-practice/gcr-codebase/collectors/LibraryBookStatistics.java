import java.util.*;
import java.util.stream.Collectors;
class Book {
    private String title;
    private String genre;
    private int pages;
    public Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public int getPages() {
        return pages;
    }
}
public class LibraryBookStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        System.out.print("Enter number of books: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Book " + (i + 1) + ":");
            System.out.print("  Title: ");
            String title = sc.nextLine();
            System.out.print("  Genre: ");
            String genre = sc.nextLine();
            System.out.print("  Number of Pages: ");
            int pages = Integer.parseInt(sc.nextLine());
            books.add(new Book(title, genre, pages));
        }
        Map<String, IntSummaryStatistics> statsByGenre = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.summarizingInt(Book::getPages)
                ));
        System.out.println("\nLibrary Book Statistics by Genre:");
        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("  Total Pages: " + stats.getSum());
            System.out.println("  Average Pages: " + String.format("%.2f", stats.getAverage()));
            System.out.println("  Max Pages: " + stats.getMax());
            System.out.println("  Min Pages: " + stats.getMin());
            System.out.println("  Book Count: " + stats.getCount());
        });
    }
}
