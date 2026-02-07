import java.util.*;
import java.util.stream.Collectors;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine();
        String[] words = paragraph.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
        Map<String, Integer> wordCount = Arrays.stream(words)
                .collect(Collectors.toMap(w -> w, w -> 1,Integer::sum));
        System.out.println("\nWord Frequencies:");
        wordCount.forEach((word, count) -> System.out.println(word + " : " + count));
    }
}
