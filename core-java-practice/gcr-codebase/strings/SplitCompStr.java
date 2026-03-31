import java.util.Scanner;
public class SplitCompStr {

    // Method to find length of string without using length()
    static int stringLength(String str) {
        int Count = 0;
        try {
            while (true) {
                str.charAt(Count);
                Count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string
        }
        return Count;
    }

    // Method to split text into words using charAt()
    static String[] splitUsingCharAt(String text) {

        int len = stringLength(text);

        // Step 1: Count number of words
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        // Step 2: Store space indexes
        int[] spaceIndex = new int[wordCount + 1];
        int idx = 0;
        spaceIndex[idx++] = -1;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[idx++] = i;
            }
        }
        spaceIndex[idx] = len;

        // Step 3: Extract words using indexes
        String[] words = new String[wordCount];
        int w = 0;

        for (int i = 0; i < spaceIndex.length - 1; i++) {
            int start = spaceIndex[i] + 1;
            int end = spaceIndex[i + 1];

            if (start < end) {
                String word = "";
                for (int j = start; j < end; j++) {
                    word += text.charAt(j);
                }
                words[w++] = word;
            }
        }
        return words;
    }

    // Method to compare two String arrays
    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // User-defined split
        String[] Custom_Split = splitUsingCharAt(text);

        // Built-in split
        String[] Built_In_Split = text.split(" ");

        // Compare results
        boolean Res = compareArrays(Custom_Split, Built_In_Split);

        // Display result
        System.out.println("Are both split results same? " + Res);

    }
}
