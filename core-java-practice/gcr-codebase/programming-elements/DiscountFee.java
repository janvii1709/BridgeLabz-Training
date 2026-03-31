import java.util.*;
class DiscountFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input scanner 
        int fee = sc.nextInt();// original fee input
        int discountPercent = sc.nextInt();// discount percentage input
        int discount = fee * discountPercent / 100;// discount calculation
        int finalFee = fee - discount;// final fee after discount calculation
        System.out.println("The discount amount is INR " + discount + " and the final discounted fee is INR " + finalFee);
    }
}