import java.util.*;
class PurchaseOfItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantity = sc.nextInt();
        double unitPrice = sc.nextDouble();
        double totalpurchasePrice = quantity * unitPrice;
        System.out.println("The total purchase price is INR " + totalpurchasePrice + " if the quantity is " + quantity + " and unit price is INR " + unitPrice);
        
    }
    
}
