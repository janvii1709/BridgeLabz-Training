import java.util.Scanner;
interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        if (password.length() < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
public class InsurancePortalSecurity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a password to validate: ");
        String password = sc.nextLine();
        boolean isStrong = SecurityUtils.isStrongPassword(password);
        if (isStrong) {
            System.out.println("Password is STRONG ");
        } else {
            System.out.println("Password is WEAK ");
        }
    }
}
