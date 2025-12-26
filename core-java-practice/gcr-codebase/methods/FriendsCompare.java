import java.util.Scanner;
public class FriendsCompare {
    // Method to find the youngest friend
    public static int FindYoungest(int[] Ages) {
        int YoungestIndex = 0;

        for (int i = 1; i < Ages.length; i++) {
            if (Ages[i] < Ages[YoungestIndex]) {
                YoungestIndex = i;
            }
        }
        return YoungestIndex;
    }

    // Method to find the tallest friend
    public static int FindTallest(int[] Heights) {
        int TallestIndex = 0;

        for (int i = 1; i < Heights.length; i++) {
            if (Heights[i] > Heights[TallestIndex]) {
                TallestIndex = i;
            }
        }
        return TallestIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] Names = {"Amar", "Akbar", "Anthony"};
        int[] Ages = new int[3];
        int[] Heights = new int[3];

        // Taking input
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + Names[i] + ": ");
            Ages[i] = sc.nextInt();

            System.out.print("Enter height of " + Names[i] + ": ");
            Heights[i] = sc.nextInt();
        }

        int YoungestIndex =FindYoungest(Ages);
        int TallestIndex = FindTallest(Heights);

        // Display results
        System.out.println("\nYoungest Friend: " + Names[YoungestIndex]);
        System.out.println("Tallest Friend: " + Names[TallestIndex]);
    }
}
