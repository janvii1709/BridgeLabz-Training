import java.util.Scanner;

// Node class representing a Ticket
class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

// Circular Linked List for Ticket Reservation System
class TicketReservationSystem {
    private Ticket tail; // tail points to the last ticket

    public TicketReservationSystem() {
        tail = null;
    }

    // Add ticket at the end
    public void addTicket(Ticket newTicket) {
        if (tail == null) {
            tail = newTicket;
            tail.next = tail; // circular link
        } else {
            newTicket.next = tail.next; // new ticket points to head
            tail.next = newTicket; // old tail points to new ticket
            tail = newTicket; // update tail
        }
        System.out.println("Ticket added for " + newTicket.customerName);
    }

    // Remove ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (tail == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = tail.next; // head
        Ticket prev = tail;
        boolean found = false;

        do {
            if (current.ticketID == ticketID) {
                found = true;
                if (current == tail && current == tail.next) { // only one ticket
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev; // update tail if removing last
                    }
                }
                System.out.println("Ticket removed: " + ticketID);
                break;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);

        if (!found) {
            System.out.println("Ticket ID not found: " + ticketID);
        }
    }

    // Display all tickets
    public void displayTickets() {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = tail.next; // head
        System.out.println("Current Tickets:");
        do {
            System.out.println(current.ticketID + " | " + current.customerName + " | " + current.movieName +
                    " | " + current.seatNumber + " | " + current.bookingTime);
            current = current.next;
        } while (current != tail.next);
    }

    // Search tickets by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = tail.next;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Found Ticket: " + current.ticketID + " | " + current.customerName +
                        " | " + current.movieName + " | " + current.seatNumber + " | " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != tail.next);

        if (!found) {
            System.out.println("No ticket found for: " + keyword);
        }
    }

    // Count total tickets
    public int countTickets() {
        if (tail == null) return 0;

        Ticket current = tail.next;
        int count = 0;
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
            System.out.println("2. Cancel Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer/Movie");
            System.out.println("5. Count Total Tickets");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customer = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();

                    Ticket ticket = new Ticket(id, customer, movie, seat, time);
                    system.addTicket(ticket);
                }
                case 2 -> {
                    System.out.print("Enter Ticket ID to cancel: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    system.removeTicket(id);
                }
                case 3 -> system.displayTickets();
                case 4 -> {
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    String keyword = sc.nextLine();
                    system.searchTicket(keyword);
                }
                case 5 -> System.out.println("Total Tickets Booked: " + system.countTickets());
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

    }
}
