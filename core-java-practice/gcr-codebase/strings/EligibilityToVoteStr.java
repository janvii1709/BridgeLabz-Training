import java.util.Scanner;

public class EligibilityToVoteStr {

    // Method to take user input for 'Num' students' ages
    static int[] Generate_Ages(int Num, Scanner sc) {
        int[] Ages = new int[Num]; // Array to store ages
        for (int i = 0; i < Num; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            Ages[i] = sc.nextInt(); // Take input from user
        }
        return Ages;
    }

    // Method to check voting eligibility
    static String[][] Check_Voting(int[] Ages) {
        String[][] Res = new String[Ages.length][2]; // 2D array to store age and status
        for (int i = 0; i < Ages.length; i++) {
            Res[i][0] = String.valueOf(Ages[i]); // Store age as string
            if (Ages[i] < 0) { // Negative age
                Res[i][1] = "Cannot Vote";
            } else if (Ages[i] >= 18) { // Eligible
                Res[i][1] = "Can Vote";
            } else { // Below 18
                Res[i][1] = "Cannot Vote";
            }
        }
        return Res;
    }

    // Method to display 2D array in tabular format
    static void Display_Table(String[][] table) {
        System.out.println("\nAge\tStatus");
        for (String[] Row : table)
            System.out.println(Row[0] + "\t" + Row[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = 10; // Number of students

        int[] Ages = Generate_Ages(Num, sc); // Get ages from user
        String[][] table = Check_Voting(Ages); // Check eligibility
        Display_Table(table); // Display results
    }
}
