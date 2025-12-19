class UniversityProblem{
    public static void main(String[] args) {
        int Fee = 125000;// original fee
        int DiscountPercent = 10;// discount percentage
        int discount = Fee * DiscountPercent / 100;// discount calculation
        int finalFee = Fee - discount;// final fee after discount calculation
        System.out.println("The discount amount is INR " + discount + " and the final discounted fee is INR " + finalFee);
    }
}