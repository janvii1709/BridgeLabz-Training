class Ride {
    User user;
    Driver driver;
    double fare;
    boolean peak;

    Ride(User user, Driver driver, double fare, boolean peak) {
        this.user = user;
        this.driver = driver;
        this.fare = fare;
        this.peak = peak;
    }

    void display() {
        System.out.println(
            "User: " + user.name +
            " | Driver: " + driver.name +
            " | Fare: ₹" + fare +
            " | Peak: " + peak
        );
    }
}
