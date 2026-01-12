public class SeasonalPricing implements PricingStrategy {
    public double calculatePrice(double basePrice, int days) {
        return (basePrice * days) + 500; // seasonal charge
    }
}
