class Driver {
    int driverId;
    String name;
    String phone;
    boolean available;

    Driver(int driverId, String name, String phone) 
            throws InvalidPhoneNumberException {
        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(
                "Phone number must be 10 digits"
            );
        }
        this.driverId = driverId;
        this.name = name;
        this.phone = phone;
        this.available = true; // initially available
    }
}
