import java.time.LocalDate;
import java.util.*;
class PolicyManager {
    Set<InsurancePolicy> hashSet = new HashSet<>();
    Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
    Set<InsurancePolicy> treeSet = new TreeSet<>();
    void addPolicy(InsurancePolicy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }
    void displayAllPolicies() {
        for (InsurancePolicy p : linkedHashSet) {
            System.out.println(p);
        }
    }
    void policiesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        boolean found = false;
        for (InsurancePolicy p : treeSet) {
            if (!p.expiryDate.isBefore(today) &&
                !p.expiryDate.isAfter(limit)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No policies expiring in next 30 days.");
        }
    }
    void showExpiredPolicies() {
        LocalDate today = LocalDate.now();
        boolean found = false;
        for (InsurancePolicy p : treeSet) {
            if (p.expiryDate.isBefore(today)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expired policies found.");
        }
    }
    void policiesByCoverage(String type) {
        boolean found = false;
        for (InsurancePolicy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No policies found for coverage type: " + type);
        }
    }
    void findDuplicatePolicies(List<InsurancePolicy> list) {
        Set<Integer> seen = new HashSet<>();
        boolean found = false;
        for (InsurancePolicy p : list) {
            if (!seen.add(p.policyNumber)) {
                System.out.println("Duplicate Policy Found: " + p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No duplicate policies found.");
        }
    }
}
