public class NormalPricing implements PricingStrategy {
    public double calculatePrice(double basePrice, int days) {
        return basePrice * days;
    }
}
