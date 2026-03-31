import java.util.Scanner;
public class SandeepFitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] PushUps = new int[7];
        System.out.println("Enter push-ups for 7 days (enter 0 for rest day):");
        for (int i = 0; i < 7; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            PushUps[i] = sc.nextInt();
            // loop if a negative number is entered 
            while (PushUps[i] < 0) {
                System.out.print("Invalid input! Enter again: ");
                PushUps[i] = sc.nextInt();
            }
        }
        int Total = 0;
        int WorkoutDays = 0;
        // for-each loop
        for (int count : PushUps) {
            if (count <= 0) {
                continue; // skip rest day or the invalid inputs like a negative number
            }
            Total += count;
            WorkoutDays++;
        }
        double Average = (double) Total / WorkoutDays;
        System.out.println("\nTotal Push-ups in the week: " + Total);
        System.out.println("Average Push-ups per workout day: " + Average);
    }
}



