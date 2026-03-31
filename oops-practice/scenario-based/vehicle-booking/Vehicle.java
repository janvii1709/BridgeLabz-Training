// Parent Vehicle class
public class Vehicle implements IRentable {

    protected int vehicleId;      // protected field
    protected String brand;       // protected field
    protected double rentPerDay;  // protected field

    public Vehicle(int vehicleId, String brand, double rentPerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.rentPerDay = rentPerDay;
    }

    // Default rent calculation
    public double calculateRent(int days) {
        return rentPerDay * days;
    }

    // Display vehicle details
    public void displayVehicle() {
        System.out.println(
                "ID: " + vehicleId +
                " | Brand: " + brand +
                " | Rent/Day: INR " + rentPerDay
        );
    }
}
