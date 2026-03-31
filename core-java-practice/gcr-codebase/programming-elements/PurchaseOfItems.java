import java.util.*;
class PurchaseOfItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input scanner
        int quantity = sc.nextInt();// taking quantity as input
        double unitPrice = sc.nextDouble();// taking unit price as input
        double totalpurchasePrice = quantity * unitPrice;// calculating total purchase price
        System.out.println("The total purchase price is INR " + totalpurchasePrice + " if the quantity is " + quantity + " and unit price is INR " + unitPrice);
        
    }
    
}
