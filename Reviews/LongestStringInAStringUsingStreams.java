import java.util.*;
public class LongestStringInAStringUsingStreams{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();
        String longestWord = Arrays.stream(str.split(" "))
                                .max(Comparator.comparingInt(String::length))
                                .orElse("");
        System.out.println("Longest word: " + longestWord);
    }
}
