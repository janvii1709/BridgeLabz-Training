// Customer class stores rental details
public class Customer {

    int customerId;
    String customerName;
    Vehicle vehicle;
    int days;

    public Customer(int customerId, String customerName, Vehicle vehicle, int days) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.vehicle = vehicle;
        this.days = days;
    }

    public void displayRental() {
        System.out.println(
                "Customer ID: " + customerId +
                " | Name: " + customerName +
                " | Vehicle: " + vehicle.brand +
                " | Days: " + days +
                " | Total Rent: ₹" + vehicle.calculateRent(days)
        );
    }
}
