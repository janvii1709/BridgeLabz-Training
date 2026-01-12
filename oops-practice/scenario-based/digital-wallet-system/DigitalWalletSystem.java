import java.util.*;

public class DigitalWalletSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Digital Wallet Menu ---");
            System.out.println("1. Create User Wallet");
            System.out.println("2. Add Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createUser();
                case 2 -> addMoney();
                case 3 -> withdrawMoney();
                case 4 -> transferFunds();
                case 5 -> viewTransactions();
                case 6 -> {
                    System.out.println("Wallet system closed");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ---------- METHODS ----------

    static User findUser(int userId) {
        for (User u : users)
            if (u.userId == userId)
                return u;
        return null;
    }

    static void createUser() {
        System.out.print("Enter User ID: ");
        int uid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter User Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Wallet ID: ");
        int wid = sc.nextInt();

        users.add(new User(uid, name, wid));
        System.out.println("User wallet created successfully");
    }

    static void addMoney() {
        System.out.print("Enter User ID: ");
        int uid = sc.nextInt();

        User user = findUser(uid);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        user.wallet.balance += amount;
        user.wallet.addTransaction("Add Money", amount);
        System.out.println("Money added successfully");
    }

    static void withdrawMoney() {
        try {
            System.out.print("Enter User ID: ");
            int uid = sc.nextInt();

            User user = findUser(uid);
            if (user == null) {
                System.out.println("User not found");
                return;
            }

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            if (user.wallet.balance < amount)
                throw new InsufficientBalanceException("Insufficient balance!");

            user.wallet.balance -= amount;
            user.wallet.addTransaction("Withdraw", amount);
            System.out.println("Money withdrawn successfully");

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    static void transferFunds() {
        try {
            System.out.print("Enter Sender User ID: ");
            int fromId = sc.nextInt();

            System.out.print("Enter Receiver User ID: ");
            int toId = sc.nextInt();

            User fromUser = findUser(fromId);
            User toUser = findUser(toId);

            if (fromUser == null || toUser == null) {
                System.out.println("Invalid users");
                return;
            }

            System.out.println("1. Wallet Transfer");
            System.out.println("2. Bank Transfer");
            int type = sc.nextInt();

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            TransferService service =
                    (type == 1) ? new WalletTransfer() : new BankTransfer();

            service.transfer(fromUser.wallet, toUser.wallet, amount);

            fromUser.wallet.addTransaction("Transfer Sent", amount);
            toUser.wallet.addTransaction("Transfer Received", amount);

            System.out.println("Transfer successful");

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    static void viewTransactions() {
        System.out.print("Enter User ID: ");
        int uid = sc.nextInt();

        User user = findUser(uid);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("\n--- Transaction History ---");
        for (Transaction t : user.wallet.transactions) {
            System.out.println(t.type + " : INR " + t.amount);
        }
        System.out.println("Current Balance: INR " + user.wallet.balance);
    }
}
