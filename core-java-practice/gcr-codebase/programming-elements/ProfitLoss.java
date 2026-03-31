class ProfitLoss {
    public static void main(String[] args) {
        int CostPrice = 129;// cost price of the item
        int SellingPrice = 191;// selling price of the item
        int profit = (SellingPrice - CostPrice);// calculation of profit
        double PorfitPercent = (profit/(double)CostPrice)*100; // calculation of profit percentage
        System.out.println("The Cost Price is INR" + CostPrice + " and Selling Price is INR" + SellingPrice +"\n The Profit is INR " + profit + "and the Profit Percentage is " + String.format("%.2f", PorfitPercent));
    }
}