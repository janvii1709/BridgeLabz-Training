// Truck class extends Vehicle
public class Truck extends Vehicle {

    public Truck(int vehicleId, String brand, double rentPerDay) {
        super(vehicleId, brand, rentPerDay);
    }

    // Polymorphic rent calculation (extra charge)
    @Override
    public double calculateRent(int days) {
        return (rentPerDay * days) + 1000;
    }
}
