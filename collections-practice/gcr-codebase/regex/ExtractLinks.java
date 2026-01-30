import java.util.*;
import java.util.regex.*;
public class ExtractLinks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text :");
        String input = sc.nextLine();
        String regex = "https?://[\\w.-] +";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
    
}
