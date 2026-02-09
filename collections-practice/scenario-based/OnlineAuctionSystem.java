import java.util.*;
// Custom Exception
class InvalidBidException extends Exception {
    public InvalidBidException(String msg) {
        super(msg);
    }
}
// User Class
class User {
    String name;
    User(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
// Auction Item Class
class AuctionItem {
    String itemName;
    double basePrice;
    AuctionItem(String itemName, double basePrice) {
        this.itemName = itemName;
        this.basePrice = basePrice;
    }
}
public class OnlineAuctionSystem {
    public static void main(String[] args) throws InvalidBidException {
        Scanner sc = new Scanner(System.in);
        TreeMap<Double, User> bids = new TreeMap<>();
        System.out.print("Enter Auction Item Name: ");
        String itemName = sc.nextLine();
        System.out.print("Enter Base Price: ");
        double basePrice = sc.nextDouble();
        sc.nextLine();
        AuctionItem item = new AuctionItem(itemName, basePrice);
        System.out.print("Enter number of bidders: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter User Name: ");
            String userName = sc.nextLine();
            User user = new User(userName);
            System.out.print("Enter Bid Amount: ");
            double bidAmount = sc.nextDouble();
            sc.nextLine();
            double currentHighest = bids.isEmpty() ? item.basePrice : bids.lastKey();
            if (bidAmount <= currentHighest)
                throw new InvalidBidException("Bid must be higher than current highest bid: " + currentHighest);
            bids.put(bidAmount, user);
            System.out.println("Bid accepted!");
        }
        Map.Entry<Double, User> highestBid = bids.lastEntry();
        System.out.println("\nHighest Bid:");
        System.out.println("User: " + highestBid.getValue());
        System.out.println("Amount: " + highestBid.getKey());
    }
}
