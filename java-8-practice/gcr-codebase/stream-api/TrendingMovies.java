import java.util.*;

class Movie {
    private String name;
    private double rating;
    private int releaseYear;

    Movie(String name, double rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}

public class TrendingMovies {
    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
            new Movie("Dangal", 4.9, 2016),
            new Movie("PK", 4.6, 2014),
            new Movie("Jawan", 4.5, 2023),
            new Movie("Drishyam", 4.8, 2015),
            new Movie("Shershaah", 4.6, 2021)
        );

        System.out.println("Top 5 Trending Movies");

        movies.stream()
              .filter(m -> m.getRating() > 4.0)
              .sorted(
                  Comparator.comparing(Movie::getRating, Comparator.reverseOrder())
                            .thenComparing(Movie::getReleaseYear, Comparator.reverseOrder())
              )
              .limit(5)
              .forEach(m -> System.out.println(
                  m.getName() + " | Rating: " + m.getRating() +
                  " | Release Year: " + m.getReleaseYear()
              ));
    }
}
