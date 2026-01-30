import java.util.*;
public class ReplaceSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        str = str.replaceAll("\\s+", " ");
        System.out.println(str);
    }
}
