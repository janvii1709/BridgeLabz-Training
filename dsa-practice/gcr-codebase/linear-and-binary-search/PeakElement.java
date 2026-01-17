import java.util.*;
public class PeakElement {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                //peak lies on the right side
                left = mid + 1;   
            } else {
                //peak lies on the left side or mid
                right = mid;     
            }
        }
        // if left == right , it is the peak element then
        return left; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element: " + arr[peakIndex]);
        System.out.println("Peak index: " + peakIndex);
    }
}
