import java.util.*;
public class YoungestFriendArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Names of friends
        String[] Names = {"Amar", "Akbar", "Anthony"};
        // Arrays to store age and height
        int[] AGE = new int[3];
        double[] HEIGHT = new double[3];
        // Taking age and height for each friend as input
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for " + Names[i]);
            System.out.print("Enter age: ");
            AGE[i] = sc.nextInt();
            System.out.print("Enter height (in cm): ");
            HEIGHT[i] = sc.nextDouble();
        }
        // Assuming that the first friend is youngest and tallest initially
        int YOUNGEST_INDEX = 0;
        int TALLEST_INDEX = 0;
        // Finding youngest (minimum age) and tallest (maximum height)
        for (int i = 1; i < 3; i++) {
            // Check for youngest friend
            if (AGE[i] < AGE[YOUNGEST_INDEX]) {
                YOUNGEST_INDEX = i;
            }
            // Check for tallest friend
            if (HEIGHT[i] > HEIGHT[TALLEST_INDEX]) {
                TALLEST_INDEX = i;
            }
        }
        System.out.println("Youngest Friend : " + Names[YOUNGEST_INDEX] + " (Age = " + AGE[YOUNGEST_INDEX] + ")");
        System.out.println("Tallest Friend  : " + Names[TALLEST_INDEX] +" (Height = " + HEIGHT[TALLEST_INDEX] + " cm)");

    }
    
}