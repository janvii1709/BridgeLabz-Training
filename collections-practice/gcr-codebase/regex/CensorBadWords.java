import java.util.*;
public class CensorBadWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = sc.nextLine();
        String[] badwords = {"damn" , "shit" , "stupid"};
        for(String word : badwords){
            sentence = sentence.replaceAll("\\b" + word  + "\\b", "****");
        }
        System.out.println("The required sentence is : " + sentence);

    }
    
}
