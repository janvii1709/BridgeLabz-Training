class NormalFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 20;
    }
}
