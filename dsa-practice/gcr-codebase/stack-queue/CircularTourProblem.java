import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Circular Tour Problem using Queue 
public class CircularTourProblem {

    // Function to find starting petrol pump
    public static int findStartingPump(int[] petrol, int[] distance) {

        int n = petrol.length;

        // Try each pump as starting point
        for (int start = 0; start < n; start++) {

            Queue<Integer> queue = new LinkedList<>();
            int currentPetrol = 0;
            int count = 0;
            int i = start;

            // Simulate circular tour
            while (count < n) {

                currentPetrol += petrol[i];
                currentPetrol -= distance[i];

                // If petrol becomes negative, break
                if (currentPetrol < 0) {
                    break;
                }

                queue.add(i);
                i = (i + 1) % n;
                count++;
            }

            // If all pumps covered, return start
            if (count == n) {
                return start;
            }
        }

        return -1; // Tour not possible
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        System.out.println("Enter petrol available at each pump:");
        for (int i = 0; i < n; i++) {
            petrol[i] = sc.nextInt();
        }

        System.out.println("Enter distance to next pump:");
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
        }

        int startPump = findStartingPump(petrol, distance);

        if (startPump == -1) {
            System.out.println("\nCircular tour is NOT possible.");
        } else {
            System.out.println("\nStart the tour from petrol pump index: " + startPump);
        }

    }
}
