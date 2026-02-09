import java.util.*;
// Custom Exception
class InvalidRatingException extends Exception {
    public InvalidRatingException(String msg) {
        super(msg);
    }
}
public class EventFeedbackAnalyzer {
    public static void main(String[] args) throws InvalidRatingException {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Integer>> feedbackMap = new HashMap<>();
        System.out.print("Enter number of events: ");
        int events = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < events; i++) {
            System.out.print("\nEnter Event ID: ");
            String eventId = sc.nextLine();
            System.out.print("Enter number of ratings: ");
            int ratingsCount = sc.nextInt();
            List<Integer> ratings = new ArrayList<>();
            for (int j = 0; j < ratingsCount; j++) {
                System.out.print("Enter rating (1-5): ");
                int rating = sc.nextInt();
                if (rating < 1 || rating > 5)
                    throw new InvalidRatingException("Invalid Rating: " + rating);
                ratings.add(rating);
            }
            feedbackMap.put(eventId, ratings);
            sc.nextLine();
        }
        // Average Calculation
        String topEvent = null;
        double highestAvg = 0;
        System.out.println("\n--- Event Ratings ---");
        for (Map.Entry<String, List<Integer>> entry : feedbackMap.entrySet()) {
            double avg = entry.getValue()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0);
            System.out.println(entry.getKey() + " -> Average Rating: " + avg);
            if (avg > highestAvg) {
                highestAvg = avg;
                topEvent = entry.getKey();
            }
        }
        System.out.println("\nTop Rated Event: " + topEvent + " (Rating: " + highestAvg + ")");
    }
}
