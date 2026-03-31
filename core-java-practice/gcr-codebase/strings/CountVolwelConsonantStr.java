import java.util.Scanner;
public class CountVolwelConsonantStr {
    // Method to check if a character is a vowel, consonant, or not a letter
    static String Char_Type(char C) {
        // Convert uppercase to lowercase using ASCII
        if (C >= 'A' && C <= 'Z') {
            C = (char)(C + 32);
        }

        // Check if character is a letter
        if (C >= 'a' && C <= 'z') {
            if (C == 'a' || C == 'e' || C == 'i' || C == 'o' || C == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // Method to count vowels and consonants in a string
    // Returns an array: [vowelCount, consonantCount]
    static int[] Count_Vowels_Consonants(String T1) {
        int Vowel_Count = 0;
        int Consonant_Count = 0;

        for (int i = 0; i < T1.length(); i++) {
            char c = T1.charAt(i);
            String type = Char_Type(c);
            if (type.equals("Vowel")) {
                Vowel_Count++;
            } else if (type.equals("Consonant")) {
                Consonant_Count++;
            }
        }

        return new int[]{Vowel_Count, Consonant_Count};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String T1 = sc.nextLine();

        // Count vowels and consonants
        int[] Counts = Count_Vowels_Consonants(T1);

        // Display results
        System.out.println("Number of vowels: " + Counts[0]);
        System.out.println("Number of consonants: " + Counts[1]);
    }
}
