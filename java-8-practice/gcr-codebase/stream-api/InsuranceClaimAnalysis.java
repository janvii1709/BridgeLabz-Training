import java.util.*;
import java.util.stream.*;
class Claim {
    private String claimType;
    private double claimAmount;
    Claim(String claimType, double claimAmount) {
        this.claimType = claimType;
        this.claimAmount = claimAmount;
    }
    public String getClaimType() {
        return claimType;
    }
    public double getClaimAmount() {
        return claimAmount;
    }
}
public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("Health", 50000),
            new Claim("Vehicle", 20000),
            new Claim("Health", 70000),
            new Claim("Life", 100000),
            new Claim("Vehicle", 30000),
            new Claim("Health", 60000)
        );
        Map<String, Double> averageClaims =
                claims.stream()
                      .collect(Collectors.groupingBy(
                          Claim::getClaimType,
                          Collectors.averagingDouble(Claim::getClaimAmount)
                      ));
        System.out.println("Average Claim Amount by Claim Type:");
        averageClaims.forEach((type, avg) ->
            System.out.println(type + " : " + avg)
        );
    }
}
