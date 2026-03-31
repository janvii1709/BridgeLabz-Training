import java.util.*;
class CreatorStats {
    public String creatorName;
    public double[] weeklyLikes;
    public static List<CreatorStats> engagementBoard = new ArrayList<>();
    public CreatorStats(String creatorName, double[] weeklyLikes) {
        this.creatorName = creatorName;
        this.weeklyLikes = weeklyLikes;
    }
}
public class StreamBuzzApp {
    // Register a creator
    public void registerCreator(CreatorStats record) {
        CreatorStats.engagementBoard.add(record);
        System.out.println("Creator registered successfully");
    }

    // Get top post counts based on like threshold
    public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {
        Map<String, Integer> topPosts = new LinkedHashMap<>();

        for (CreatorStats creator : records) {
            int count = 0;
            for (double likes : creator.weeklyLikes) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) { // Only include creators with at least 1 week above threshold
                topPosts.put(creator.creatorName, count);
            }
        }

        return topPosts;
    }

    // Calculate overall average likes
    public double calculateAverageLikes() {
        double totalLikes = 0;
        int totalWeeks = 0;

        for (CreatorStats creator : CreatorStats.engagementBoard) {
            for (double likes : creator.weeklyLikes) {
                totalLikes += likes;
                totalWeeks++;
            }
        }

        if (totalWeeks == 0) return 0;
        return totalLikes / totalWeeks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StreamBuzzApp program = new StreamBuzzApp();
        boolean running = true;

        while (running) {
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Register Creator
                    System.out.print("Enter Creator Name: ");
                    String name = sc.nextLine();

                    double[] likes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        System.out.print("Week " + (i + 1) + ": ");
                        likes[i] = sc.nextDouble();
                    }
                    sc.nextLine(); // Consume newline

                    CreatorStats creator = new CreatorStats(name, likes);
                    program.registerCreator(creator);
                    break;

                case 2:
                    // Show Top Posts
                    System.out.print("Enter like threshold: ");
                    double threshold = sc.nextDouble();
                    sc.nextLine(); // Consume newline

                    Map<String, Integer> topPosts = program.getTopPostCounts(CreatorStats.engagementBoard, threshold);
                    if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    // Calculate Average Likes
                    double avgLikes = program.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + (int) avgLikes);
                    break;

                case 4:
                    // Exit
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }

            System.out.println(); // Add a blank line for readability
        }

        sc.close();
    }
}
