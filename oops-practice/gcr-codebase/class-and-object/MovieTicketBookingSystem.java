class MovieTicketBookingSystem {
    String MovieName, SeatNumber;
    double Price;
    boolean Booked = false;
    int HouseFullCount = 0;  
    void BookTicket(String Movie, String Seat, double Price) {
        if (Booked) {
            System.out.println("House full!!! sorry..... Ticket already booked");
            HouseFullCount++;
            if (HouseFullCount == 2) {  
                System.out.println("Price: $" + this.Price);
            }
        } else {
            Booked = true;
            MovieName = Movie;
            SeatNumber = Seat;
            this.Price = Price;
            System.out.println("Ticket booked for movie: " + MovieName);
            System.out.println("Seat Number: " + SeatNumber);
        }
    }
    void Display() {
        if (!Booked)
            System.out.println("Ticket have not booked yet....");
        else {
            System.out.println("Ticket booked for movie: " + MovieName);
            System.out.println("Seat Number: " + SeatNumber);
            System.out.println("Price: $" + Price);
        }
    }
    public static void main(String[] args) {
        MovieTicketBookingSystem m = new MovieTicketBookingSystem();
        m.Display();
        m.BookTicket("Dragon", "A10", 120);
        m.BookTicket("Dragon", "A10", 120);
        m.BookTicket("Dragon", "A10", 120);
        System.out.println();
        m.Display();
    }
}
