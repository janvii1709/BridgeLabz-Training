import java.util.*;
public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> accounts = new HashMap<>();
        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();
            System.out.print("Enter Balance: ");
            int balance = sc.nextInt();
            accounts.put(accNo, balance);
        }
        System.out.println("\nAll Accounts:");
        for (Map.Entry<Integer, Integer> entry : accounts.entrySet()) {
            System.out.println("Account " + entry.getKey() + " → Balance: " + entry.getValue());
        }
        TreeMap<Integer, List<Integer>> sortedByBalance = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : accounts.entrySet()) {
            int accNo = entry.getKey();
            int balance = entry.getValue();
            sortedByBalance.putIfAbsent(balance, new ArrayList<>());
            sortedByBalance.get(balance).add(accNo);
        }
        System.out.println("\nCustomers Sorted by Balance:");
        for (Map.Entry<Integer, List<Integer>> entry : sortedByBalance.entrySet()) {
            for (Integer acc : entry.getValue()) {
                System.out.println("Account " + acc + " → Balance: " + entry.getKey());
            }
        }
        Queue<Integer> withdrawalQueue = new LinkedList<>();
        System.out.print("\nEnter number of withdrawal requests: ");
        int w = sc.nextInt();
        for (int i = 0; i < w; i++) {
            System.out.print("Enter account number for withdrawal: ");
            withdrawalQueue.add(sc.nextInt());
        }
        System.out.println("\nProcessing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            int accNo = withdrawalQueue.poll();
            if (accounts.containsKey(accNo)) {
                System.out.print("Enter withdrawal amount for account " + accNo + ": ");
                int amount = sc.nextInt();
                int balance = accounts.get(accNo);
                if (balance >= amount) {
                    accounts.put(accNo, balance - amount);
                    System.out.println("Withdrawal successful. New balance: " + accounts.get(accNo));
                } else {
                    System.out.println("Insufficient balance for account " + accNo);
                }
            } else {
                System.out.println("Account " + accNo + " not found");
            }
        }
    }
}
