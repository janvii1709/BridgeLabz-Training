import java.time.LocalDate;
import java.util.*;
public class PolicyService {
    private HashMap<String, Policy> policyMap = new HashMap<>();
    private LinkedHashMap<String, Policy> insertionOrderMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> expiryDateMap = new TreeMap<>();
    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        insertionOrderMap.put(policy.getPolicyNumber(), policy);
        expiryDateMap
                .computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>())
                .add(policy);
    }
    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }
    public void getPoliciesExpiringIn30Days() {
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);
        boolean found = false;
        for (List<Policy> policies : expiryDateMap
                .subMap(today, true, next30Days, true)
                .values()) {
            for (Policy policy : policies) {
                System.out.println(policy);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No policies expiring in the next 30 days.");
        }
    }
    public void getPoliciesByHolder(String holderName) {
        boolean found = false;
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(holderName)) {
                System.out.println(policy);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No policies found for this policy holder.");
        }
    }
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> iterator = policyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                iterator.remove();
                insertionOrderMap.remove(entry.getKey());
            }
        }
        expiryDateMap.headMap(today).clear();
        System.out.println("Expired policies removed successfully.");
    }
}
