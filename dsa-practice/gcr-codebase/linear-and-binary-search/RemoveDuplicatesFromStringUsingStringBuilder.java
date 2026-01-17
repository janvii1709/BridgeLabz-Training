import java.util.*;

public class RemoveDuplicatesFromStringUsingStringBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string : ");
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }

        System.out.print("String After Removing Duplicates Is : ");
        System.out.print(sb.toString());
    }
}
