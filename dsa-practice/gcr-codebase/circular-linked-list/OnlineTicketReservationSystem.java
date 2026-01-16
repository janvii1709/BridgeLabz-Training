import java.util.Scanner;

// Node class
class Ticket {
    private int ticketId;
    private String customerName;
    private String movieName;
    private String seatNumber;
    private String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName,
                  String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDetails() {
        return ticketId + " | " + customerName + " | " +
               movieName + " | " + seatNumber + " | " + bookingTime;
    }
}

// Circular Linked List
class TicketReservationSystem {

    private Ticket tail;

    public TicketReservationSystem() {
        tail = null;
    }

    // Add ticket
    public void addTicket(Ticket newTicket) {
        if (tail == null) {
            tail = newTicket;
            tail.next = tail;
        } else {
            newTicket.next = tail.next;
            tail.next = newTicket;
            tail = newTicket;
        }
        System.out.println("Ticket booked successfully!");
    }

    // Remove ticket by ID
    public void removeTicket(int ticketId) {
        if (tail == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = tail.next;
        Ticket prev = tail;

        do {
            if (current.getTicketId() == ticketId) {

                if (current == tail && current == tail.next) {
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }

                System.out.println("Ticket cancelled: " + ticketId);
                return;
            }

            prev = current;
            current = current.next;

        } while (current != tail.next);

        System.out.println("Ticket ID not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = tail.next;
        System.out.println("Booked Tickets:");
        do {
            System.out.println(current.getDetails());
            current = current.next;
        } while (current != tail.next);
    }

    // Search ticket by customer or movie
    public void searchTicket(String key) {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = tail.next;
        boolean found = false;

        do {
            if (current.getCustomerName().equalsIgnoreCase(key) ||
                current.getMovieName().equalsIgnoreCase(key)) {
                System.out.println(current.getDetails());
                found = true;
            }
            current = current.next;
        } while (current != tail.next);

        if (!found) {
            System.out.println("No matching ticket found.");
        }
    }

    // Count tickets
    public int countTickets() {
        if (tail == null) return 0;

        int count = 0;
        Ticket current = tail.next;
        do {
            count++;
            current = current.next;
        } while (current != tail.next);

        return count;
    }
}

// Main class
public class OnlineTicketReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();
        int choice;

        do {
            System.out.println("\n--- Online Ticket Reservation System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Count Tickets");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Customer Name: ");
                    String customer = sc.nextLine();

                    System.out.print("Movie Name: ");
                    String movie = sc.nextLine();

                    System.out.print("Seat Number: ");
                    String seat = sc.nextLine();

                    System.out.print("Booking Time: ");
                    String time = sc.nextLine();

                    system.addTicket(new Ticket(id, customer, movie, seat, time));
                    break;

                case 2:
                    System.out.print("Enter Ticket ID: ");
                    system.removeTicket(sc.nextInt());
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer or Movie Name: ");
                    system.searchTicket(sc.nextLine());
                    break;

                case 5:
                    System.out.println("Total Tickets: " + system.countTickets());
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }
}
