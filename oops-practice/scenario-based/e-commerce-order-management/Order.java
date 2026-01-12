public class Order {
    private int orderId;
    private Product product;
    private Customer customer;
    private int orderQuantity;
    private String status;

    public Order(int orderId, Product product, Customer customer, int orderQuantity) {
        this.orderId = orderId;
        this.product = product;
        this.customer = customer;
        this.orderQuantity = orderQuantity;
        this.status = "PLACED";
    }

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return product.getPrice() * orderQuantity;
    }

    public void trackOrder() {
        System.out.println(
            "Order ID: " + orderId +
            " | Customer: " + customer.getName() +
            " | Quantity: " + orderQuantity +
            " | Status: " + status
        );
    }

    public void cancelOrder() {
        if (status.equals("CANCELLED")) {
            System.out.println("Order already cancelled");
        } else {
            status = "CANCELLED";
            System.out.println("Order cancelled successfully");
        }
    }
}
