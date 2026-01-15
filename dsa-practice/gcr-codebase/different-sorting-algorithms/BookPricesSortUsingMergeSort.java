import java.util.*;
public class BookPricesSortUsingMergeSort {
    public static void bookPrice(int[] price , int left , int right){
        if(left > right){
            int mid = left + ( right - left) / 2 ;
            bookPrice (price , left , mid);
            bookPrice(price , mid + 1 , right);
            merge(price , left , mid , right);
        }
    }
    private static void merge(int[] price , int left , int mid , int right){
        int n1 = mid - left + 1 ;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        System.arraycopy(price , left , leftArray , 0 , n1);
        System.arraycopy(price , mid + 1 , rightArray , 0 , n2);
        int i = 0 , j = 0 , k = left;
        while(i < n1 && j < n2){
            if(leftArray[i] <= rightArray[j]){
                price[k++] = leftArray[i++];
            } else {
                price[k++] = rightArray[j++];
            }
    }
        while ( i < n1) price[k++] = leftArray[i++];
        while (j < n2) price[k++] = rightArray[j++];
    
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of books : ");
    int n = sc.nextInt();
    int[] price = new int[n];
    for(int i = 0 ; i < n ; i++){
        System.out.print("Enter the price of book " + (i + 1) + " is : ");
        price[i] = sc.nextInt();
        
    }
    bookPrice(price , 0 , price.length - 1 );
    System.out.print("Sorted book price i n ascending order is : ");
    System.out.print(Arrays.toString(price));
}


}
