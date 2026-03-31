import java.util.Scanner;
public class SplitCompareStr {
    // Method to find length of string without using length()
    static int String_Length(String str) {
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
    static String[] Split_Using_CharAt(String text) {
        int Len = String_Length(text);
        // Count number of words
        int Word_Count = 0;
        boolean In_Word = false;
        for (int i = 0; i < Len; i++) {
            if (text.charAt(i) != ' ' && !In_Word) {
                Word_Count++;
                In_Word = true;
            } else if (text.charAt(i) == ' ') {
                In_Word = false;
            }
        }

        // Step 2: Store space indexes
        int[] spaceIndex = new int[Word_Count + 1];
        int idx = 0;
        spaceIndex[idx++] = -1;

        for (int i = 0; i < Len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[idx++] = i;
            }
        }
        spaceIndex[idx] = Len;

        // Step 3: Extract words using indexes
        String[] words = new String[Word_Count];
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
        String[] customSplit = Split_Using_CharAt(text);

        // Built-in split
        String[] builtInSplit = text.split(" ");

        // Compare results
        boolean result = compareArrays(customSplit, builtInSplit);

        // Display result
        System.out.println("Are both split results same? " + result);

    }
}

