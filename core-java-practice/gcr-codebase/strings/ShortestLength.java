import java.util.Scanner;

public class ShortestLength {

    // Method to calculate the length of a string without using length()
    static int stringLength(String str) {
        int Count = 0;
        try {
            while (true) {
                str.charAt(Count);
                Count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Reached the end of string
        }
        return Count;
    }

    // Method to split text into words using charAt() without using split()
    static String[] splitText(String T1) {
        String Word = "";
        String[] Temp_Words = new String[100]; // Max 100 words
        int Index = 0;

        for (int i = 0; i < stringLength(T1); i++) {
            char c = T1.charAt(i);
            if (c != ' ') { // Part of a word
                Word += c;
            } else if (!Word.equals("")) { // End of a word
                Temp_Words[Index++] = Word;
                Word = "";
            }
        }
        if (!Word.equals("")) { // Add last word
            Temp_Words[Index++] = Word;
        }

        // Copy to array of correct size
        String[] Words = new String[Index];
        for (int i = 0; i < Index; i++) {
            Words[i] = Temp_Words[i];
        }
        return Words;
    }

    // Method to get word lengths and return 2D array [word, length]
    static String[][] wordLengths(String[] Words) {
        String[][] Res = new String[Words.length][2];
        for (int i = 0; i < Words.length; i++) {
            Res[i][0] = Words[i];
            Res[i][1] = String.valueOf(stringLength(Words[i]));
        }
        return Res;
    }

    // Method to find shortest and longest words using 2D array
    static String[] shortestLongest(String[][] Word_Array) {
        String Shortest = Word_Array[0][0];
        String Longest = Word_Array[0][0];
        int minLen = Integer.parseInt(Word_Array[0][1]);
        int maxLen = Integer.parseInt(Word_Array[0][1]);

        for (int i = 1; i < Word_Array.length; i++) {
            int len = Integer.parseInt(Word_Array[i][1]);
            if (len < minLen) {
                minLen = len;
                Shortest = Word_Array[i][0];
            }
            if (len > maxLen) {
                maxLen = len;
                Longest = Word_Array[i][0];
            }
        }

        return new String[]{Shortest, Longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Split text into words
        String[] Words = splitText(text);

        // Get word lengths in 2D array
        String[][] Word_Array = wordLengths(Words);

        // Find shortest and longest words
        String[] Res = shortestLongest(Word_Array);

        // Display results
        System.out.println("Shortest word: " +Res[0]);
        System.out.println("Longest word: " + Res[1]);

    }
}
