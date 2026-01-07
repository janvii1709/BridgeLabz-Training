import java.util.*;
public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first string ");
        String str1 = sc.nextLine();
        System.out.print("Enter the second string ");
        String str2 = sc.nextLine();
        if(isAnagram(str1,str2)){
            System.out.println("The strings are anagram");
        }
        else{
            System.out.println("The strings are not anagram");
        }

    }
    public static boolean isAnagram(String str1,String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        else{
            int [] freq = new int[26];
            for(int i=0;i<str1.length();i++){
                freq[str1.charAt(i)-'a']++;
                freq[str2.charAt(i)-'a']--;
            }
            for(int i=0;i<26;i++){
                if(freq[i] != 0){
                    return false;
                }
            }
            return true;
        }
    }
}