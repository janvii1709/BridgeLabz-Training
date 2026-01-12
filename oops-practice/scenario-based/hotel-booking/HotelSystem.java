import java.util.*;

public class HotelSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Guest> guests = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Hotel Reservation Menu ---");
            System.out.println("1. Add Room");
            System.out.println("2. Add Guest");
            System.out.println("3. View Rooms");
            System.out.println("4. Book Room");
            System.out.println("5. Check-In");
            System.out.println("6. Check-Out & Invoice");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addRoom();
                case 2 -> addGuest();
                case 3 -> viewRooms();
                case 4 -> bookRoom();
                case 5 -> checkIn();
                case 6 -> checkOut();
                case 7 -> {
                    System.out.println("System Closed");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ---------- METHODS ----------

    static void addRoom() {
        System.out.println("1. Standard Room\n2. Deluxe Room");
        int type = sc.nextInt();

        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        if (type == 1)
            rooms.add(new StandardRoom(roomNo));
        else
            rooms.add(new DeluxeRoom(roomNo));

        System.out.println("Room added successfully");
    }

    static void addGuest() {
        System.out.print("Enter Guest ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Guest Name: ");
        String name = sc.nextLine();

        guests.add(new Guest(id, name));
        System.out.println("Guest added successfully");
    }

    static void viewRooms() {
        for (Room r : rooms) {
            r.display();
        }
    }

    static void bookRoom() {
        try {
            if (guests.isEmpty())
                throw new RoomNotAvailableException("No guests registered!");

            System.out.println("Available Guests:");
            for (Guest g : guests)
                System.out.println(g.guestId + " - " + g.name);

            System.out.print("Enter Guest ID: ");
            int gid = sc.nextInt();

            Guest selectedGuest = null;
            for (Guest g : guests)
                if (g.guestId == gid)
                    selectedGuest = g;

            if (selectedGuest == null)
                throw new RoomNotAvailableException("Guest not found");

            Room freeRoom = null;
            for (Room r : rooms)
                if (r.available)
                    freeRoom = r;

            if (freeRoom == null)
                throw new RoomNotAvailableException("No rooms available!");

            System.out.print("Enter number of stay days: ");
            int days = sc.nextInt();

            freeRoom.available = false;
            reservations.add(new Reservation(selectedGuest, freeRoom, days));

            System.out.println("Room booked successfully. Room No: " + freeRoom.roomNo);

        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }

    static void checkIn() {
        System.out.print("Enter Room Number: ");
        int rno = sc.nextInt();

        for (Reservation r : reservations) {
            if (r.room.roomNo == rno && !r.checkedIn) {
                r.checkedIn = true;
                System.out.println("Check-in successful");
                return;
            }
        }
        System.out.println("Reservation not found");
    }

    static void checkOut() {
        System.out.print("Enter Room Number: ");
        int rno = sc.nextInt();

        for (Reservation r : reservations) {
            if (r.room.roomNo == rno && r.checkedIn && !r.checkedOut) {

                System.out.println("1. Normal Pricing\n2. Seasonal Pricing");
                int p = sc.nextInt();

                PricingStrategy pricing =
                        (p == 1) ? new NormalPricing() : new SeasonalPricing();

                double bill = pricing.calculatePrice(r.room.pricePerDay, r.days);

                r.checkedOut = true;
                r.room.available = true;

                System.out.println("\n--- Invoice ---");
                System.out.println("Guest: " + r.guest.name);
                System.out.println("Room No: " + r.room.roomNo);
                System.out.println("Days: " + r.days);
                System.out.println("Amount: INR " + bill);
                return;
            }
        }
        System.out.println("Check-in not found");
    }
}
