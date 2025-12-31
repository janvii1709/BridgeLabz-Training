public class HotelBooking {
    String guestName;
    String roomType;
    int nights;
    // Default constructor
    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }
    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    // Copy constructor
    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }
    // Method to display booking details
    void display() {
        System.out.println("Guest Name : " + guestName);
        System.out.println("Room Type  : " + roomType);
        System.out.println("Nights     : " + nights);
        System.out.println("------------------------------------");
    }
    // Main method
    public static void main(String[] args) {
        // Default booking
        HotelBooking b1 = new HotelBooking();
        System.out.println("These are details of the booking using default constructor");
        b1.display();
          System.out.println(); // For extra line
        // Parameterized booking
        HotelBooking b2 = new HotelBooking("Janhavi", "Deluxe", 3);
        System.out.println("These are details of the booking using parameterized constructor");
        b2.display();
          System.out.println(); // For extra line
        // Copy booking
        HotelBooking b3 = new HotelBooking(b2);
        System.out.println("These are details of the booking using copy constructor");
        b3.display();
        System.out.println(); // For extra line
    }
}
