import java.util.Scanner;

public class EventManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Input ticket prices
        System.out.print("Enter number of tickets: ");
        int n = sc.nextInt();
        int[] tickets = new int[n];

        System.out.println("Enter ticket prices: ");
        for (int i = 0; i < n; i++) {
            tickets[i] = sc.nextInt();
        }

        //Sort tickets using Quick Sort
        quickSort(tickets, 0, n - 1);

        System.out.println("Sorted tickets (ascending):");
        printArray(tickets);

        //Ask user for top K
        System.out.print("Enter how many top cheapest tickets to show: ");
        int kCheapest = sc.nextInt();

        System.out.print("Enter how many top expensive tickets to show: ");
        int kExpensive = sc.nextInt();

        System.out.println("\nTop " + kCheapest + " cheapest tickets:");
        printTopK(tickets, kCheapest, true);

        System.out.println("\nTop " + kExpensive + " most expensive tickets:");
        printTopK(tickets, kExpensive, false);
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }

    private static void printTopK(int[] arr, int k, boolean cheapest) {
        int n = arr.length;
        int limit = Math.min(k, n);

        if (cheapest) {
            for (int i = 0; i < limit; i++) System.out.print(arr[i] + " ");
        } else {
            for (int i = n - 1; i >= n - limit; i--) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
