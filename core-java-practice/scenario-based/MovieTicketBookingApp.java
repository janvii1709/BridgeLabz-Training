import java.util.Scanner;
public class MovieTicketBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char NextCustomer = 'y';
        do {
            int TotalPrice = 0;
            int TicketPrice = 0;
            // Movie type validation
            String Movie;
            while (true) {
                System.out.print("Movie type (action/comedy/drama/horror/scifi/romance): ");
                Movie = sc.nextLine().trim().toLowerCase();
                if (Movie.equals("action") || Movie.equals("comedy") || Movie.equals("drama") ||
                    Movie.equals("horror") || Movie.equals("scifi") || Movie.equals("romance")) {
                    break;
                } else {
                    System.out.println("Invalid movie type! Enter again.");
                }
            }

            // Seat type validation
            String Seat;
            while (true) {
                System.out.print("Seat type (gold/silver): ");
                Seat = sc.nextLine().trim().toLowerCase();
                if (Seat.equals("gold") || Seat.equals("silver")) {
                    break;
                } else {
                    System.out.println("Invalid seat type! Enter again.");
                }
            }

            // Movie + Seat price
            switch (Movie) {
                case "action":
                    if (Seat.equals("gold")) TicketPrice = 350;
                    else TicketPrice = 250;
                    break;
                case "comedy":
                    if (Seat.equals("gold")) TicketPrice = 300;
                    else TicketPrice = 200;
                    break;
                case "drama":
                    if (Seat.equals("gold")) TicketPrice = 280;
                    else TicketPrice = 180;
                    break;
                case "horror":
                    if (Seat.equals("gold")) TicketPrice = 320;
                    else TicketPrice = 220;
                    break;
                case "scifi":
                    if (Seat.equals("gold")) TicketPrice = 400;
                    else TicketPrice = 300;
                    break;
                case "romance":
                    if (Seat.equals("gold")) TicketPrice = 290;
                    else TicketPrice = 190;
                    break;
            }

            // Number of tickets validation
            int Tickets;
            while (true) {
                System.out.print("Number of tickets: ");
                if (sc.hasNextInt()) {
                    Tickets = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    if (Tickets > 0) break;
                } else {
                    sc.nextLine(); // clear invalid input
                }
                System.out.println("Enter a valid positive number of tickets!");
            }

            TotalPrice = TicketPrice * Tickets;

            // Snacks yes/no validation
            String SnackChoice;
            while (true) {
                System.out.print("Add snacks? (yes/no): ");
                SnackChoice = sc.nextLine().trim().toLowerCase();
                if (SnackChoice.equals("yes") || SnackChoice.equals("no")) break;
                System.out.println("Enter yes or no!");
            }

            // Snack selection loop
            if (SnackChoice.equals("yes")) {
                char MoreSnacks = 'y';
                while (MoreSnacks == 'y') {

                    System.out.println("\nSnacks Menu:");
                    System.out.println("1. ColdDrink - 60");
                    System.out.println("2. Burger - 120");
                    System.out.println("3. Popcorn - 100");
                    System.out.println("4. SweetCorn - 90");
                    System.out.println("5. Pizza - 150");
                    System.out.println("6. Burger Meal (Burger + ColdDrink) - 160");
                    System.out.println("7. Pizza Meal (Pizza + ColdDrink) - 190");
                    System.out.println("8. Popcorn Meal (Popcorn + ColdDrink) - 140");

                    int Snack;
                    while (true) {
                        System.out.print("Choose snack (1-8): ");
                        if (sc.hasNextInt()) {
                            Snack = sc.nextInt();
                            sc.nextLine(); // clear buffer
                            if (Snack >= 1 && Snack <= 8) break;
                        } else {
                            sc.nextLine(); // clear invalid input
                        }
                        System.out.println("Invalid choice! Enter 1-8.");
                    }

                    switch (Snack) {
                        case 1: TotalPrice += 60; break;
                        case 2: TotalPrice += 120; break;
                        case 3: TotalPrice += 100; break;
                        case 4: TotalPrice += 90; break;
                        case 5: TotalPrice += 150; break;
                        case 6: TotalPrice += 160; break;
                        case 7: TotalPrice += 190; break;
                        case 8: TotalPrice += 140; break;
                    }

                    // More snacks yes/no validation
                    while (true) {
                        System.out.print("More snacks? (y/n): ");
                        String Temp = sc.nextLine().trim().toLowerCase();
                        if (Temp.equals("y") || Temp.equals("n")) {
                            MoreSnacks = Temp.charAt(0);
                            break;
                        }
                        System.out.println("Enter y or n!");
                    }
                }
            }

            System.out.println("\nFinal Bill Amount = INR " + TotalPrice);
            // Next customer yes/no validation
            while (true) {
                System.out.print("Next customer? (y/n): ");
                String temp = sc.nextLine().trim().toLowerCase();
                if (temp.equals("y") || temp.equals("n")) {
                    NextCustomer = temp.charAt(0);
                    break;
                }
                System.out.println("Enter y or n!");
            }

        } while (NextCustomer == 'y');
    }
}
