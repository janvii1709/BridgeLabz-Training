import java.util.Scanner;
public class VotingApp {
    public static void main(String[] args) {
        VotingService service = new VotingService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Voting System ---");
            System.out.println("1. Cast Vote");
            System.out.println("2. Display Votes (Insertion Order)");
            System.out.println("3. Display Results (Sorted)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Candidate Name: ");
                    String name = sc.nextLine();
                    service.castVote(name);
                    break;
                case 2:
                    service.displayVoteOrder();
                    break;
                case 3:
                    service.displaySortedResults();
                    break;
                case 4:
                    System.out.println("Exiting Voting System...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
