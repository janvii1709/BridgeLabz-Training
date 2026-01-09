// Car class extends Vehicle
public class Car extends Vehicle {

    public Car(int vehicleId, String brand, double rentPerDay) {
        super(vehicleId, brand, rentPerDay);
    }

    // Polymorphic rent calculation (extra charge)
    @Override
    public double calculateRent(int days) {
        return (rentPerDay * days) + 500;
    }
}
