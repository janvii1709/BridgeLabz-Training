
public class RandomGenerate {

    // Method to generate array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] Numbers = new int[size];

        for (int i = 0; i < size; i++) {
            // generates random 4-digit number (1000 to 9999)
            Numbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return Numbers;
    }

    // Method to find average, minimum and maximum
    public static double[] findAverageMinMax(int[] Numbers) {
        int Sum = 0;
        int Min = Numbers[0];
        int Max = Numbers[0];

        for (int num : Numbers) {
            Sum += num;
            Min = Math.min(Min, num);
            Max = Math.max(Max, num);
        }

        double Average = (double) Sum / Numbers.length;

        return new double[] { Average, Min, Max };
    }

    public static void main(String[] args) {

        // Generate 5 random 4-digit numbers
        int[] Numbers = generate4DigitRandomArray(5);

        System.out.println("Generated Numbers:");
        for (int num : Numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Find average, min and max
        double[] Output = findAverageMinMax(Numbers);

        System.out.println("Average Value: " + Output[0]);
        System.out.println("Minimum Value: " + (int) Output[1]);
        System.out.println("Maximum Value: " + (int) Output[2]);
    }
}
