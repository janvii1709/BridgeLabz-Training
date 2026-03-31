import java.util.*;
public class FreqOfCharStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take input string from user
        System.out.print("Enter a string: ");
        String Str = sc.nextLine();
        // Calculate string length manually without using length()
        int Num = 0;
        try {
            while (true) {
                Str.charAt(Num); // Access character at index n
                Num++;           // Increment count
            }
        } catch (IndexOutOfBoundsException e) {
            // Exception occurs when index exceeds string length
        }

        // Create frequency array for all ASCII characters
        int[] Freq = new int[256];

        // Count frequency of each character
        for (int i = 0; i < Num; i++) {
            char Ch = Str.charAt(i); // Get character at index i
            Freq[Ch]++;              // Increment frequency
        }

        // Count number of unique characters to create 2D array
        int Unique_Count = 0;
        for (int i = 0; i < 256; i++) {
            if (Freq[i] > 0) {
                Unique_Count++;
            }
        }

        // Create 2D array to store character and its frequency
        int[][] Res = new int[Unique_Count][2];
        int INDEX = 0;
        for (int i = 0; i < 256; i++) {
            if (Freq[i] > 0) {
                Res[INDEX][0] = i;      // ASCII value of character
                Res[INDEX][1] = Freq[i]; // Frequency
                INDEX++;
            }
        }

        // Displaying characters and their frequencies
        System.out.println("Character : Frequency");
        for (int i = 0; i < Unique_Count; i++) {
            System.out.println((char)Res[i][0] + " : " +Res[i][1]);

    }
}
}