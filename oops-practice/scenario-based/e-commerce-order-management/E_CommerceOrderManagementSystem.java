import java.util.ArrayList;
import java.util.Scanner;

public class E_CommerceOrderManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        int orderId = 1;

        while (true) {
            System.out.println("\n--- E-Commerce Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Add Customer");
            System.out.println("3. Place Order");
            System.out.println("4. Track Orders");
            System.out.println("5. Cancel Order");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1: // Add Product
                    System.out.print("Product ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Product Name: ");
                    String pname = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Available Quantity: ");
                    int qty = sc.nextInt();

                    products.add(new Product(pid, pname, price, qty));
                    System.out.println("Product Added Successfully");
                    break;

                case 2: // Add Customer
                    System.out.print("Customer ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Customer Name: ");
                    String cname = sc.nextLine();

                    customers.add(new Customer(cid, cname));
                    System.out.println("Customer Added Successfully");
                    break;

                case 3: // Place Order
                    if (products.isEmpty() || customers.isEmpty()) {
                        System.out.println("Add products and customers first");
                        break;
                    }

                    System.out.println("Products:");
                    for (Product p : products)
                        p.display();

                    System.out.print("Enter Product ID: ");
                    int prodId = sc.nextInt();

                    Product selectedProduct = null;
                    for (Product p : products)
                        if (p.getProductId() == prodId)
                            selectedProduct = p;

                    System.out.print("Enter Order Quantity: ");
                    int orderQty = sc.nextInt();

                    if (orderQty > selectedProduct.getQuantity()) {
                        System.out.println("Not enough stock available");
                        break;
                    }

                    System.out.println("Customers:");
                    for (Customer c : customers)
                        System.out.println(c.getCustomerId() + " | " + c.getName());

                    System.out.print("Enter Customer ID: ");
                    int custId = sc.nextInt();

                    Customer selectedCustomer = null;
                    for (Customer c : customers)
                        if (c.getCustomerId() == custId)
                            selectedCustomer = c;

                    Order order = new Order(orderId++, selectedProduct, selectedCustomer, orderQty);

                    System.out.println("Payment Method:");
                    System.out.println("1. Card\n2. UPI\n3. Wallet");
                    int payChoice = sc.nextInt();

                    Payment payment = null;
                    if (payChoice == 1) payment = new CardPayment();
                    else if (payChoice == 2) payment = new UPIPayment();
                    else if (payChoice == 3) payment = new WalletPayment();

                    try {
                        payment.pay(order.getAmount());
                        selectedProduct.reduceQuantity(orderQty); // 🔥 stock reduce
                        orders.add(order);
                        System.out.println("Order Placed Successfully");
                    } catch (PaymentFailedException e) {
                        System.out.println("Payment Failed: " + e.getMessage());
                    }
                    break;

                case 4: // Track Orders
                    if (orders.isEmpty()) {
                        System.out.println("No Orders Found");
                        break;
                    }
                    for (Order o : orders)
                        o.trackOrder();
                    break;

                case 5: // Cancel Order
                    System.out.print("Enter Order ID to Cancel: ");
                    int cancelId = sc.nextInt();

                    boolean found = false;
                    for (Order o : orders) {
                        if (o.getOrderId() == cancelId) {
                            o.cancelOrder();
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Order ID not found");
                    break;

                case 6:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
