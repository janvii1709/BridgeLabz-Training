import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the path of the text file: ");
        String filename = sc.nextLine();
        HashMap<String, Integer> wordCount = new HashMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.isEmpty()) continue;
                    word = word.toLowerCase();
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
            int totalWords = wordCount.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("\nTotal words in the file: " + totalWords);
            List<Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
            list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            System.out.println("\nTop 5 most frequent words:");
            for (int i = 0; i < Math.min(5, list.size()); i++) {
                Entry<String, Integer> entry = list.get(i);
                System.out.println((i + 1) + ". " + entry.getKey() + " : " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Error closing BufferedReader.");
            }
        }
    }
}
