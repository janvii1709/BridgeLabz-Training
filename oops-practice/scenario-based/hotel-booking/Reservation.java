public class Reservation {
    Guest guest;
    Room room;
    int days;
    boolean checkedIn;
    boolean checkedOut;

    public Reservation(Guest guest, Room room, int days) {
        this.guest = guest;
        this.room = room;
        this.days = days;
    }
}
