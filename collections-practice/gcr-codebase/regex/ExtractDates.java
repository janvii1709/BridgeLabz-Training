import java.util.*;
import java.util.regex.*;
public class ExtractDates {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text : ");
        String text = sc.nextLine();
        String regex = "\\b\\d{2}[/-]\\d{2}[/-]\\d{4}\\b";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    
}
