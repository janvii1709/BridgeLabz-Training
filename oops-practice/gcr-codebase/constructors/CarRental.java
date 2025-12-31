public class CarRental {
    // Attributes (data members)
    String customerName;
    String carModel;
    int rentalDays;
    // Constant rent per day
    static final int RENT_PER_DAY = 1000;
    // Default constructor
    // This constructor sets default values
    CarRental() {
        customerName = "Guest";
        carModel = "Standard";
        rentalDays = 1;
    }
    // Parameterized constructor
    // This constructor takes values from the user/program
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }
    // Method to calculate total rental cost
    int calculateTotalCost() {
        return rentalDays * RENT_PER_DAY;
    }
    // Method to display rental details
    void displayDetails() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Car Model     : " + carModel);
        System.out.println("Rental Days   : " + rentalDays);
        System.out.println("Total Cost    : INR " + calculateTotalCost());
        System.out.println("---------------------------");
    }
    // Main method
    public static void main(String[] args) {
        // Object using default constructor
        CarRental Rent1 = new CarRental();
        System.out.println("Objects created using Default Constructor");
        System.out.println(); // For extra line
        Rent1.displayDetails();

        // Object using parameterized constructor
        CarRental Rent2 = new CarRental("Janhavi", "SUV", 5);
        System.out.println("Objects created using Parameterized Constructor");
        System.out.println(); // For extra line
        Rent2.displayDetails();
    }
}
