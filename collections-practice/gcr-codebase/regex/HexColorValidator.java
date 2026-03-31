import java.util.Scanner;
public class HexColorValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter hex color code: ");
        String color = sc.nextLine();
        String regex = "^#[A-Fa-f0-9]{6}$";
        if (color.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
    
}
