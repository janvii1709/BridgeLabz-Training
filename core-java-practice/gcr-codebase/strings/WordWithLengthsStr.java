import java.util.Scanner;
public class WordWithLengthsStr {

    // Method to find the length of a string without using length()
    static int String_Length(String str) {
        int Count = 0;
        try {
            while (true) {
                str.charAt(Count);
                Count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string reached
        }
        return Count;
    }

    // Method to split text into words using charAt() without split()
    static String[] splitText(String T1) {
        String Word = "";
        String[] Temp = new String[100]; // Temporary array for words
        int Index = 0;

        for (int i = 0; i < String_Length(T1); i++) {
            char c = T1.charAt(i);
            if (c != ' ') {
                Word += c;
            } else if (!Word.equals("")) {
                Temp[Index++] = Word;
                Word = "";
            }
        }
        if (!Word.equals("")) {
            Temp[Index++] = Word;
        }

        // Copy words to array of exact size
        String[] Words = new String[Index];
        for (int i = 0; i < Index; i++) {
            Words[i] = Temp[i];
        }
        return Words;
    }

    // Method to create 2D array of words and their lengths
    static String[][] Word_Lengths(String[] Words) {
        String[][] Res = new String[Words.length][2];
        for (int i = 0; i < Words.length; i++) {
            Res[i][0] = Words[i];
            Res[i][1] = String.valueOf(String_Length(Words[i]));
        }
        return Res;
    }

    // Method to display the 2D array in tabular format
    static void Display_Table(String[][] Word_Array) {
        System.out.println("Word\tLength");
        for (String[] Row : Word_Array) {
            int Len = Integer.parseInt(Row[1]); // Convert length to integer
            System.out.println(Row[0] + "\t" + Len);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String T1 = sc.nextLine();

        // Split text into words
        String[] Words = splitText(T1);

        // Get 2D array of words and lengths
        String[][] Word_Array = Word_Lengths(Words);

        // Display the result in tabular format
        Display_Table(Word_Array);
    }
}
