import java.io.*;
import java.util.*;
public class CountWordInFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking the file name from user
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        // Taking theword to search
        System.out.print("Enter word to search: ");
        String word = sc.nextLine();
        int count = 0;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            // Reading the file line by line
            while ((line = br.readLine()) != null) {
                // Spliting the line into words
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
            }
            System.out.println("This Word '" + word + "' occurred " + count + " times.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
