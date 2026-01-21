public class Electronics extends WarehouseItem {
    private int warrantyMonths;

    public Electronics(String name, double price, int warrantyMonths) {
        super(name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics: " + name + ", Price: $" + price + ", Warranty: " + warrantyMonths + " months");
    }
}
