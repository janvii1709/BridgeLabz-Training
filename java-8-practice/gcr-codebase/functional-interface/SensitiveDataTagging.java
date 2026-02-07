import java.util.Scanner;
interface SensitiveData {
}
class UserAccount implements SensitiveData {
    String username;
    String password;
    UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
public class SensitiveDataTagging {
    static String encrypt(String data) {
        return new StringBuilder(data).reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        UserAccount account = new UserAccount(username, password);
        if (account instanceof SensitiveData) {
            System.out.println("\nSensitive data detected. Encrypting...");
            String encryptedPassword = encrypt(account.password);
            System.out.println("Encrypted Username: " + encrypt(account.username));
            System.out.println("Encrypted Password: " + encryptedPassword);
        } else {
            System.out.println("Data is not sensitive. No encryption required.");
        }
    }
}
