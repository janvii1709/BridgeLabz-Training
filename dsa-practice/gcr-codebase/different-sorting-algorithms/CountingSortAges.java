import java.util.Scanner;

public class CountingSortAges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            if (ages[i] < 10 || ages[i] > 18) {
                System.out.println("Age must be between 10 and 18!");
                i--; 
            }
        }
        countingSort(ages);
        System.out.println("\nAges in ascending order:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }

    public static void countingSort(int[] arr) {
        int min = 10; 
        int max = 18; 
        int range = max - min + 1;

        int[] count = new int[range]; 
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
        }
    }
}
