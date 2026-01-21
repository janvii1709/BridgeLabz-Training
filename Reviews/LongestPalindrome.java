import java.util.*;
public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str = sc.nextLine();
        int n = str.length();
        int maxLength = 0;
        int start = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                String sub = str.substring(i, j+1);
                if(isPalindrome(sub)){
                    if(sub.length() > maxLength){
                        maxLength = sub.length();
                        start = i;
                    }
                }
            }
        }
        System.out.println(str.substring(start, start+maxLength));
    
}
    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
