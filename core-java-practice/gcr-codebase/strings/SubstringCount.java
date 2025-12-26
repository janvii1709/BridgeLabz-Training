import java.util.Scanner;

public class SubstringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter the main string: ");
        String MainString = sc.nextLine();

        // Input substring to search
        System.out.print("Enter the substring to count: ");
        String SubString = sc.nextLine();

        int Count = 0;
        int Index = 0;

        // Loop through the string to find occurrences
        while ((Index = MainString.indexOf(SubString, Index)) != -1) {
            Count++;
            Index += SubString.length(); // Move past this occurrence
        }

        // Display the result
        System.out.println("The substring \"" + SubString + "\" occurs " + Count + " times.");
    }
}

