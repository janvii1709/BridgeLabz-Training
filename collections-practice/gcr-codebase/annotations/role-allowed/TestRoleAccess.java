import java.util.Scanner;
public class TestRoleAccess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your role (ADMIN / USER): ");
        String role = sc.nextLine();
        AdminService service = new AdminService();
        AccessManager.checkAccessAndExecute(service, role);
    }
}
