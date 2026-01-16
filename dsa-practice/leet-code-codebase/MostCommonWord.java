import java.util.Scanner;
public class MostCommonWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter paragraph:");
        String paragraph = sc.nextLine().toLowerCase();
        System.out.println("Enter number of banned words:");
        int n = sc.nextInt();
        sc.nextLine(); 
        String[] banned = new String[n];
        System.out.println("Enter banned words:");
        for (int i = 0; i < n; i++) {
            banned[i] = sc.nextLine().toLowerCase();
        }
        String cleaned = "";
        for (int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);
            if (ch >= 'a' && ch <= 'z' || ch == ' ') {
                cleaned += ch;
            } else {
                cleaned += " ";
            }
        }
        String[] words = cleaned.split(" ");
        String result = "";
        int maxCount = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0) continue;
            boolean isBanned = false;
            for (int b = 0; b < banned.length; b++) {
                if (words[i].equals(banned[b])) {
                    isBanned = true;
                    break;
                }
            }
            if (isBanned) continue;
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                result = words[i];
            }
        }
        System.out.println("Most frequent non-banned word: " + result);
    }
}

