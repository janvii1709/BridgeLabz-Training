
import java.util.Scanner;

public class FrequentChar{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String Input = sc.nextLine();

        // Convert to lowercase to treat upper and lower case equally (optional)
        String str = Input.toLowerCase();

        int[] Freq = new int[256]; // ASCII character frequency array

        // Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            Freq[str.charAt(i)]++;
        }

        // Find the character with maximum frequency
        int Max = -1;
        char MostFrequent = ' ';

        for (int i = 0; i < str.length(); i++) {
            if (Freq[str.charAt(i)] > Max) {
                Max = Freq[str.charAt(i)];
                MostFrequent = str.charAt(i);
            }
        }

        // Display the result
        System.out.println("Most Frequent Character: '" + MostFrequent + "'");
    }
}
