class ProfitLoss {
    public static void main(String[] args) {
        int CostPrice = 129;
        int SellingPrice = 191;
        int profit = (SellingPrice - CostPrice);
        double PorfitPercent = (profit/(double)CostPrice)*100;
        System.out.println("The Cost Price is INR" + CostPrice + " and Selling Price is INR" + SellingPrice +"\n The Profit is INR " + profit + "and the Profit Percentage is " + String.format("%.2f", PorfitPercent));
    }
}