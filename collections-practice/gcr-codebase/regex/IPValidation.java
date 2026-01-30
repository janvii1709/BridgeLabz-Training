import java.util.*;
public class IPValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter IP address:");
        String ip = sc.nextLine();
        String regex ="^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)"+ "(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}$";
        if (ip.matches(regex)) {
            System.out.println("Valid IP address");
        } else {
            System.out.println("Invalid IP address");
        }
    }
}
