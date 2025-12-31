public class Vehicle {
    // Instance variables (unique for each vehicle)
    String OwnerName;
    String VehicleType;
    // Class variable (same for all vehicles)
    static double RegistrationFee = 5000;  // default fee
    // Parameterized constructor
    // Initializes vehicle details
    Vehicle(String OwnerName, String VehicleType) {
        this.OwnerName = OwnerName;
        this.VehicleType = VehicleType;
    }
    // Instance method
    // Displays details of one vehicle
    void displayVehicleDetails() {
        System.out.println("Owner Name       : " + OwnerName);
        System.out.println("Vehicle Type     : " + VehicleType);
        System.out.println("Registration Fee : INR " + RegistrationFee);
        System.out.println("-------------------------------------------");
    }
    // Class (static) method
    // Updates registration fee for all vehicles
    static void UpdateRegistrationFee(double NewFee) {
        RegistrationFee = NewFee;
    }
    // Main method
    public static void main(String[] args) {
        // Creating vehicle objects
        Vehicle vehicle1 = new Vehicle("Janhavi", "Car");
        Vehicle vehicle2 = new Vehicle("Rahul", "Bike");
        // Display details before updating fee
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
        // Update registration fee for all vehicles
        Vehicle.UpdateRegistrationFee(6000);
        // Display details after updating fee
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}
