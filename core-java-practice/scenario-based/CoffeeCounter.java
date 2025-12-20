import java.util.*;
public class CoffeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double GSTRATE = 0.05; // GST = 5%
        System.out.print(" Enter the number of customers: ");
        int Customers = sc.nextInt();
        int CustomerNumb = 1;
        // Loop for customers
        while (CustomerNumb <= Customers) {
            System.out.println("Customer " + CustomerNumb );
                System.out.print("Enter coffee type (Espresso / Latte / Cappuccino / ClassicCold / Mocha) or 'exit': ");
                String CoffeeType = sc.next();
                // using this for exiting the statement 
                if(CoffeeType.equalsIgnoreCase("exit")){
                    System.out.println("The Cafe Is Closed ! ");
                    break;
                }
                System.out.print("Enter quantity: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid quantity! Please provide the correct input ");
                    sc.next();
                    continue;
                }
                int Quantity = sc.nextInt();

                double PricePerCoffee = 0;

                // Switch for coffee price
                switch (CoffeeType.toLowerCase()) {
                    case "espresso":
                        PricePerCoffee = 250;
                        break;
                    case "latte":
                        PricePerCoffee = 200;
                        break;
                    case "cappuccino":
                        PricePerCoffee = 220;
                        break;
                    case "classiccold":
                        PricePerCoffee = 280;
                        break;
                    case "mocha":
                        PricePerCoffee = 255;
                        break;
                    default:
                        System.out.println("Invalid coffee type!");
                        continue;
                }
                double ItemTotal = PricePerCoffee * Quantity;
                System.out.println("Added: " + CoffeeType + " x " + Quantity + " = INR " + ItemTotal);
                // GST and final bill for customer
            double GSTAmount = ItemTotal * GSTRATE;
            double BILL = ItemTotal + GSTAmount;

            System.out.println(" BILL SUMMARY ");
            System.out.println("Total (before GST): INR " + ItemTotal);
            System.out.printf("GST (5%%): INR %.2f%n", GSTAmount);
            System.out.printf("Bill: INR %.2f%n", BILL);

            System.out.println("Thank you for visiting! ");

            CustomerNumb++; // move to next customer
            }
            
        }

        
    }

