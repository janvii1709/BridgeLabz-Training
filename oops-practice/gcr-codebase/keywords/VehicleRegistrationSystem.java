// Vehicle class stores registration details of a vehicle
class Vehicle {
    // Static variable because registration fee is same for all vehicles
    static double registrationFee = 150.0;
    // Final variable so registration number cannot be changed once assigned
    final String registrationNumber;
    // Instance variables (different for each vehicle)
    String ownerName;
    String vehicleType;
    // Constructor to initialize vehicle details
    // 'this' keyword is used to point to the current object
    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;                   // Store owner's name
        this.vehicleType = vehicleType;               // Store type of vehicle
        this.registrationNumber = registrationNumber; // Store registration number
    }
    // Static method to update registration fee for all vehicles
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    // Method to display vehicle registration details
    // instanceof checks whether the object belongs to Vehicle class
    void displayDetails(Object obj) {
        if (obj instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }
}
// Main class for starting the execution of program
public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        // Create first vehicle object
        Vehicle vehicle1 = new Vehicle("Honest raj", "Sedan", "ABC123");
        // Create second vehicle object
        Vehicle vehicle2 = new Vehicle("Price danish", "SUV", "XYZ789");
        // Display details of first vehicle
        vehicle1.displayDetails(vehicle1);
        // Display details of second vehicle
        vehicle2.displayDetails(vehicle2);
    }
}
