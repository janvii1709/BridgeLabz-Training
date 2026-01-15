import java.util.*;
public class ProductPricesQuickSort {
    public static void productPrices(int [] price , int low , int high){
        if ( low < high){
            int pi = partition(price , low , high);
            productPrices(price, low , pi - 1);
            productPrices(price , pi + 1 , high);
        }
    }
    private static int partition(int[] price , int low , int high){
        int pivot = price[high];
        int i = ( low - 1);
        for(int j = low ; j < high ; j++){
            if(price[j] < pivot){
                i++;
                int temp = price[i];
                price[i] = price[j];
                price[j] = temp;
            }


        }
        int temp = price[i + 1];
        price[i + 1]= price[high];
        price[high]= temp;
        return i + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of products : ");
        int n = sc.nextInt();
        int[] price = new int[n];
        for(int i = 0 ; i < n ; i++){
            System.out.print("Enter the price of product " + ( i + 1) + " is: ");
            price[i] = sc.nextInt();
    }
    productPrices(price , 0 ,n - 1);
    System.out.print("The sorted array of the product prices is :");
    System.out.print(Arrays.toString(price));
}

    
}
