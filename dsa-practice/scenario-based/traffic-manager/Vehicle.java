public class Vehicle {
    int vehicleId;
    String vehicleName;
    Vehicle next; // pointer for circular linked list

    public Vehicle(int vehicleId, String vehicleName) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.next = null;
    }
}
