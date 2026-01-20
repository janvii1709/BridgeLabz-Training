import java.util.*;

public class CinemaManager {
    private List<Movie> movies = new ArrayList<>();

    // Add Movie
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format! Use HH:MM (00–23:00–59)");
        }
        movies.add(new Movie(title, time));
        System.out.println(" Movie added successfully!");
    }

    // Search Movie
    public void searchMovie(String keyword) {
        boolean found = false;
        try {
            for (Movie movie : movies) {
                if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(" " + movie);
                    found = true;
                }
            }
            if (!found) {
                System.out.println(" No movie found with keyword: " + keyword);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(" Error accessing movie list!");
        }
    }

    // Display All Movies
    public void displayAllMovies() {
        if (movies.isEmpty()) {
            System.out.println(" No movies scheduled.");
            return;
        }

        System.out.println("\n Movie Schedule:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i));
        }
    }

    // Generate Report (List → Array)
    public void generateReport() {
        String[] report = movies.stream()
                .map(Movie::getTitle)
                .toArray(String[]::new);

        System.out.println("\n Printable Movie Report:");
        for (String title : report) {
            System.out.println(title);
        }
    }

    // Time Validation
    private boolean isValidTime(String time) {
        if (!time.matches("\\d{2}:\\d{2}")) return false;

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
    }
}
