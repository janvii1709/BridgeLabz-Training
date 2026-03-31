import java.util.Scanner;
public class SentenceFormatter {
    // Method to format a paragraph
    public static String FormatParagraph(String Sentence) {
        // Step 1: Remove extra spaces at the start, end, and between words
        // "\\s+" matches one or more spaces, replace with single space
        Sentence = Sentence.trim().replaceAll("\\s+", " ");
        StringBuilder Formatted = new StringBuilder();
        boolean Capitalize = true; // True when we need to capitalize a letter

        // Step 2: Loop through each character in the paragraph
        for (int i = 0; i < Sentence.length(); i++) {
            char ch = Sentence.charAt(i);
            // Capitalize the first letter of a sentence
            if (Capitalize && Character.isLetter(ch)) {
                Formatted.append(Character.toUpperCase(ch));
                Capitalize = false; // Reset after capitalizing
            } else {
                Formatted.append(ch); // Add character as it is
            }
            // If the character is punctuation, mark next letter to be capital
            if (ch == '.' || ch == '?' || ch == '!') {
                Capitalize = true;
                // Ensure there is only one space after punctuation
                if (i + 1 < Sentence.length() && Sentence.charAt(i + 1) != ' ') {
                    Formatted.append(" ");
                }
            }
        }
        return Formatted.toString(); // Return the formatted paragraph
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take paragraph input from the user
        System.out.println("Enter the paragraph:");
        String Sentence = sc.nextLine();
        // Format the paragraph
        String FormattedParagraph = FormatParagraph(Sentence);
        // Display the result
        System.out.println("\nFormatted Paragraph is :");
        System.out.println(FormattedParagraph);
    }
}
