import java.util.*;

/*
 * Flight class
 * Stores details of a single flight
 */
class Flight {

    int flightId;          // numeric only
    String source;         // alphabetical only
    String destination;    // alphabetical only
    double price;          // numeric only

    Flight(int flightId, String source, String destination, double price) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    // Displays flight information
    void displayFlight() {
        System.out.println(
                "Flight ID: " + flightId +
                " | From: " + source +
                " | To: " + destination +
                " | Price: ₹" + price
        );
    }
}

/*
 * Booking class
 * Stores booking details of the user
 */
class Booking {

    int bookingId;
    Flight flight;
    String passengerName;

    Booking(int bookingId, Flight flight, String passengerName) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passengerName = passengerName;
    }

    // Displays booking information
    void displayBooking() {
        System.out.println(
                "Booking ID: " + bookingId +
                " | Passenger: " + passengerName +
                " | Route: " + flight.source + " → " + flight.destination +
                " | Price: INR " + flight.price
        );
    }
}

/*
 * Main class
 * Controls the complete Flight Booking System
 */
public class FlightBookingSystem {

    static Scanner sc = new Scanner(System.in);

    static Flight[] flights;                       // Array → stores flight data
    static List<Booking> bookings = new ArrayList<>(); // List → stores user bookings
    static int bookingCounter = 1;

    public static void main(String[] args) {

        // CREATE → Flights are added once at the start
        addFlights();

        int choice;
        do {
            System.out.println("\n===== Flight Booking System (CRUD) =====");
            System.out.println("1. Search Flights(READ)");
            System.out.println("2. Book Flight(CREATE)");
            System.out.println("3. View Bookings(READ)");
            System.out.println("4. Cancel Booking(DELETE)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("\n--- READ Operation Started ---");
                    searchFlights();
                }
                case 2 -> {
                    System.out.println("\n--- CREATE Operation Started ---");
                    bookFlight();
                }
                case 3 -> {
                    System.out.println("\n--- READ Operation Started ---");
                    viewBookings();
                }
                case 4 -> {
                    System.out.println("\n--- DELETE Operation Started ---");
                    cancelBooking();
                }
                case 5 -> System.out.println("Thank you for using Flight Booking System!");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    /*
     * CREATE operation
     * Adds flight data using user input with validation
     */
    static void addFlights() {

        System.out.print("Enter number of flights to add: ");
        while (!sc.hasNextInt()) {
            System.out.print("Enter a numeric value: ");
            sc.next();
        }
        int n = sc.nextInt();
        sc.nextLine();

        flights = new Flight[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Flight " + (i + 1));

            // Flight ID → numeric only
            System.out.print("Flight ID : ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter numeric Flight ID: ");
                sc.next();
            }
            int id = sc.nextInt();
            sc.nextLine();

            // Source City → alphabets only
            String source;
            do {
                System.out.print("Source City : ");
                source = sc.nextLine();
            } while (!source.matches("[a-zA-Z ]+"));

            // Destination City → alphabets only
            String destination;
            do {
                System.out.print("Destination City : ");
                destination = sc.nextLine();
            } while (!destination.matches("[a-zA-Z ]+"));

            // Price → numeric only
            System.out.print("Price : ");
            while (!sc.hasNextDouble()) {
                System.out.print("Invalid input. Enter numeric price: ");
                sc.next();
            }
            double price = sc.nextDouble();
            sc.nextLine();

            flights[i] = new Flight(id, source, destination, price);
        }
    }

    /*
     * READ operation
     * Searches flights using case-insensitive String comparison
     */
    static void searchFlights() {

        System.out.print("Enter source city: ");
        String sourceInput = sc.nextLine();

        System.out.print("Enter destination city: ");
        String destinationInput = sc.nextLine();

        boolean found = false;

        for (Flight flight : flights) {
            // equalsIgnoreCase() allows case-insensitive search
            if (flight.source.equalsIgnoreCase(sourceInput)
                    && flight.destination.equalsIgnoreCase(destinationInput)) {

                flight.displayFlight();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No flights found.");
        }
    }

    /*
     * CREATE operation
     * Books a flight and stores booking in List
     */
    static void bookFlight() {

        System.out.print("Enter Flight ID to book: ");
        while (!sc.hasNextInt()) {
            System.out.print("Enter numeric Flight ID: ");
            sc.next();
        }
        int flightId = sc.nextInt();
        sc.nextLine();

        Flight selectedFlight = null;
        for (Flight flight : flights) {
            if (flight.flightId == flightId) {
                selectedFlight = flight;
                break;
            }
        }

        if (selectedFlight == null) {
            System.out.println("Flight not found.");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        // Booking is stored inside List
        bookings.add(new Booking(bookingCounter++, selectedFlight, name));
        System.out.println("Flight booked successfully!");
    }

    /*
     * READ operation
     * Displays all bookings from List
     */
    static void viewBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (Booking booking : bookings) {
            booking.displayBooking();
        }
    }

    /*
     * DELETE operation
     * Cancels booking using booking ID
     */
    static void cancelBooking() {

        System.out.print("Enter Booking ID to cancel: ");
        while (!sc.hasNextInt()) {
            System.out.print("Enter numeric Booking ID: ");
            sc.next();
        }
        int id = sc.nextInt();

        Iterator<Booking> it = bookings.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Booking booking = it.next();
            if (booking.bookingId == id) {
                it.remove();
                found = true;
                System.out.println("Booking cancelled successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Booking ID not found.");
        }
    }
}
