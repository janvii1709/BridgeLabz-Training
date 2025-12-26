import java.util.Random;
public class FootBallTeamHeight {
    // Method to find sum of all heights
    public static int FindSum(int[] Heights) {
        int Sum = 0;
        for (int i = 0; i < Heights.length; i++) {
            Sum = Sum + Heights[i];
        }
        return Sum;
    }

    // Method to find mean height
    public static double FindMean(int[] Heights) {
        int Sum = FindSum(Heights);
        return (double) Sum / Heights.length;
    }

    // Method to find shortest height
    public static int FindShortest(int[] Heights) {
        int Min = Heights[0];
        for (int i = 1; i < Heights.length; i++) {
            if (Heights[i] < Min) {
                Min = Heights[i];
            }
        }
        return Min;
    }

    // Method to find tallest height
    public static int FindTallest(int[] Heights) {
        int Max = Heights[0];
        for (int i = 1; i < Heights.length; i++) {
            if (Heights[i] > Max) {
                Max = Heights[i];
            }
        }
        return Max;
    }

    public static void main(String[] args) {

        int[] Heights = new int[11];   // array of size 11
        Random Rand = new Random();

        // Generate random heights between 150 and 250
        for (int i = 0; i < Heights.length; i++) {
            Heights[i] = Rand.nextInt(101) + 150;
        }

        // Display heights
        System.out.println("Heights of football players:");
        for (int i = 0; i < Heights.length; i++) {
            System.out.print(Heights[i] + " ");
        }
        System.out.println("\nShortest Height : " + FindShortest(Heights) + " cms");
        System.out.println("Tallest Height : " + FindTallest(Heights) + " cms");
        System.out.println("Mean Height : " + FindMean(Heights) + " cms");
    }
}
