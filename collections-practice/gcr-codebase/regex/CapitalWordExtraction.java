import java.util.*;
import java.util.regex.*;
public class CapitalWordExtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Sentence : ");
        String str = sc.nextLine();
        String regex = "\\b[A-Z][a-z]*\\b";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group() + " ");
        }
    }
}
