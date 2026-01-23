import java.time.LocalDate;
import java.util.*;
public class InsurancePolicyApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PolicyManager manager = new PolicyManager();
        List<InsurancePolicy> inputList = new ArrayList<>();
        System.out.print("Enter number of policies: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter policy details:");
            System.out.print("Policy Number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Policy Holder Name: ");
            String name = sc.nextLine();
            System.out.print("Coverage Type (Health/Auto/Home): ");
            String coverage = sc.nextLine();
            System.out.print("Premium Amount: ");
            double premium = sc.nextDouble();
            System.out.print("Expiry Date (yyyy-mm-dd): ");
            LocalDate expiry = LocalDate.parse(sc.next());
            InsurancePolicy policy =
new InsurancePolicy(number, name, expiry, coverage, premium);
            manager.addPolicy(policy);
            inputList.add(policy);
        }
        System.out.println("\n--- All Unique Policies ---");
        manager.displayAllPolicies();
        System.out.println("\n--- Policies Expiring in Next 30 Days ---");
        manager.policiesExpiringSoon();
        System.out.println("\n--- Already Expired Policies ---");
        manager.showExpiredPolicies();
        sc.nextLine();
        System.out.print("\nEnter coverage type to search: ");
        String type = sc.nextLine();
        System.out.println("\n--- Policies with " + type + " Coverage ---");
        manager.policiesByCoverage(type);
        System.out.println("\n--- Duplicate Policies ---");
        manager.findDuplicatePolicies(inputList);
    }
}
