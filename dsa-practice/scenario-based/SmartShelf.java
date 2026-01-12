import java.util.Scanner;

public class SmartShelf {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Input number of books
        System.out.print("Enter number of books to add: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] books = new String[n];

        //Add books one by one
        for (int i = 0; i < n; i++) {
            System.out.print("Enter book title " + (i + 1) + ": ");
            String title = sc.nextLine();

            books[i] = title;

            // Sort the array up to current index using insertion sort
            insertionSort(books, i + 1);

            // Display current sorted shelf
            System.out.println("Current sorted shelf:");
            printArray(books, i + 1);
        }

        System.out.println("\nFinal sorted shelf:");
        printArray(books, n);
    }

    // ---------- Insertion Sort ----------
    private static void insertionSort(String[] arr, int length) {
        for (int i = 1; i < length; i++) {
            String key = arr[i];
            int j = i - 1;

            // Move elements greater than key one position ahead (case-insensitive)
            while (j >= 0 && arr[j].compareToIgnoreCase(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Print array up to current length
    private static void printArray(String[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
}
