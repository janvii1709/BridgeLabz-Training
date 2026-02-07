import java.util.*;
import java.util.stream.Collectors;
class Order {
    String customerName;
    double amount;
    Order(String customerName, double amount) {
        this.customerName = customerName;
        this.amount = amount;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getAmount() {
        return amount;
    }
}
public class OrderRevenueSummary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Order> orders = new ArrayList<>();
        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter customer name: ");
            String name = sc.next();
            System.out.print("Enter order amount: ");
            double amount = sc.nextDouble();
            orders.add(new Order(name, amount));
        }
        // ONE GO SOLUTION using summingDouble
        Map<String, Double> revenuePerCustomer = orders.stream().collect(Collectors.groupingBy(Order::getCustomerName,Collectors.summingDouble(Order::getAmount)));
        // Output
        revenuePerCustomer.forEach((customer, total) ->
                System.out.println(customer + " -> INR " + total)
        );
    }
}
