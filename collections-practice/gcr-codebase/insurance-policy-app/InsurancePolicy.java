import java.time.LocalDate;
import java.util.Objects;
class InsurancePolicy implements Comparable<InsurancePolicy> {
    int policyNumber;
    String policyHolderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;
    InsurancePolicy(int policyNumber, String policyHolderName,LocalDate expiryDate, String coverageType,double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy p = (InsurancePolicy) obj;
        return this.policyNumber == p.policyNumber;
    }
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
    @Override
    public int compareTo(InsurancePolicy p) {
        return this.expiryDate.compareTo(p.expiryDate);
    }
    @Override
    public String toString() {
        return policyNumber + " | " + policyHolderName +
                " | " + expiryDate + " | " +
                coverageType + " | INR " + premiumAmount;
    }
}
