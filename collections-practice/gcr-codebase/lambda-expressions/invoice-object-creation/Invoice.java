class Invoice {
    int transactionId;
    Invoice(int transactionId) {
        this.transactionId = transactionId;
    }
    @Override
    public String toString() {
        return "Invoice generated for Transaction ID: " + transactionId;
    }
}
