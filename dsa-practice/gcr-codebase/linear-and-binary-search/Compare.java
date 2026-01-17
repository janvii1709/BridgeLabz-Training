import java.io.*;
import java.util.*;
public class Compare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // PART 1: StringBuilder vs StringBuffer
        System.out.print("Enter a string to concatenate: ");
        String text = sc.nextLine();
        System.out.print("Enter number of times to concatenate: ");
        int times = sc.nextInt();
        sc.nextLine(); // Used to consume newline
        // StringBuilder
        long startSB = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(text);
        }
        long endSB = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (endSB - startSB) + " ms");
        // StringBuffer
        long startSBF = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < times; i++) {
            sbf.append(text);
        }
        long endSBF = System.currentTimeMillis();
        System.out.println("StringBuffer Time: " + (endSBF - startSBF) + " ms");
        // PART 2: FileReader vs InputStreamReader
        System.out.print("\nEnter file name to read: ");
        String fileName = sc.nextLine();
        //FileReader
        long startFR = System.currentTimeMillis();
        int wordCountFR = countWordsUsingFileReader(fileName);
        long endFR = System.currentTimeMillis();
        System.out.println("\nFileReader Word Count: " + wordCountFR);
        System.out.println("FileReader Time: " + (endFR - startFR) + " ms");
        // InputStreamReader
        long startISR = System.currentTimeMillis();
        int wordCountISR = countWordsUsingInputStreamReader(fileName);
        long endISR = System.currentTimeMillis();
        System.out.println("\nInputStreamReader Word Count: " + wordCountISR);
        System.out.println("InputStreamReader Time: " + (endISR - startISR) + " ms");
    }


    // Counting the words using FileReader
    public static int countWordsUsingFileReader(String fileName) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty())
                    count += words.length;
            }
        } catch (IOException e) {
            System.out.println("FileReader Error: " + e.getMessage());
        }
        return count;
    }
    // Counting the words using InputStreamReader
    public static int countWordsUsingInputStreamReader(String fileName) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty())
                    count += words.length;
            }
        } catch (IOException e) {
            System.out.println("InputStreamReader Error: " + e.getMessage());
        }
        return count;
    }
}
