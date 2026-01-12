public class User {
    int userId;
    String name;
    Wallet wallet;

    public User(int userId, String name, int walletId) {
        this.userId = userId;
        this.name = name;
        this.wallet = new Wallet(walletId);
    }
}
