public class Room {
    int roomNo;
    double pricePerDay;
    boolean available = true;

    public Room(int roomNo, double pricePerDay) {
        this.roomNo = roomNo;
        this.pricePerDay = pricePerDay;
    }

    public void display() {
        System.out.println("Room: " + roomNo +
                " | Price: " + pricePerDay +
                " | Available: " + available);
    }
}
