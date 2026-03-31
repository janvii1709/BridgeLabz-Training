import java.io.*;
import java.util.*;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter path of the text file: ");
        String filePath = sc.nextLine();
        Map<String, Integer> wordFreq = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                    }
                }
            }
            System.out.println("\nWord Frequencies:");
            for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
