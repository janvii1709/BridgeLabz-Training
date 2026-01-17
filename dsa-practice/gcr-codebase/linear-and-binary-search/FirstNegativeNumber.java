import java.util.*;
public class FirstNegativeNumber {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                // returns the index of first negative number
                return i;
            }
        }
         // When no negative number found
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int index = findFirstNegative(arr);
        if (index != -1) {
            System.out.println("The first negative number is found at index : " + index);
        } else {
            System.out.println("No negative number is found in the array ");
        }
    }
}
