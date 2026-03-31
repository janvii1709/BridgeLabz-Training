import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of stock prices:");
        int n = sc.nextInt();

        List<Double> stockPrices = new ArrayList<>();

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            stockPrices.add(sc.nextDouble());
        }

        System.out.println("\nLive Stock Price Updates:");

        stockPrices.stream()
                   .forEach(price -> System.out.println("Stock Price: INR " + price));
    }
}
