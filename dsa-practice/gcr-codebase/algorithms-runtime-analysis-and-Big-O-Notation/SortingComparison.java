import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingComparison {

    //  Bubble Sort (O(N^2))
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Array is already sorted
        }
    }

    //  Merge Sort (O(N log N))
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    //Quick Sort (O(N log N))
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
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking dataset size input
        System.out.print("Enter dataset size (N): ");
        int n = sc.nextInt();

        // Generating a random dataset
        int[] original = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            original[i] = rand.nextInt(n * 10); // Random integers
        }

        // Bubble Sort 
        if (n <= 10000) { // Avoiding the running bubble sort on huge arrays
            int[] arrBubble = Arrays.copyOf(original, n);
            long start = System.nanoTime();
            bubbleSort(arrBubble);
            long end = System.nanoTime();
            System.out.printf("Bubble Sort Time: %.5f ms\n", (end - start) / 1_000_000.0);
        } else {
            System.out.println("Bubble Sort: Skipped (Too slow for large datasets)");
        }

        //  Merge Sort 
        int[] arrMerge = Arrays.copyOf(original, n);
        long start = System.nanoTime();
        mergeSort(arrMerge, 0, n - 1);
        long end = System.nanoTime();
        System.out.printf("Merge Sort Time: %.5f ms\n", (end - start) / 1_000_000.0);

        // Quick Sort
        int[] arrQuick = Arrays.copyOf(original, n);
        start = System.nanoTime();
        quickSort(arrQuick, 0, n - 1);
        end = System.nanoTime();
        System.out.printf("Quick Sort Time: %.5f ms\n", (end - start) / 1_000_000.0);

        //Comparision result 
        System.out.println("\nExpected Result:");
        System.out.println("Bubble Sort is impractical for large datasets.");
        System.out.println("Merge Sort & Quick Sort perform well for large data.");
    }
}
