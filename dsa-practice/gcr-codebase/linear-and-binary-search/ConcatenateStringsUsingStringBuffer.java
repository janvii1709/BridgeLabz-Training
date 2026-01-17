import java.util.*;
public class ConcatenateStringsUsingStringBuffer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Number Of Strings : ");
        int n = sc.nextInt();
        sc.nextLine(); 
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter The String " + (i + 1) + " : ");
            arr[i] = sc.nextLine();
        }
        StringBuffer sb = new StringBuffer();
        for (String str : arr) {
            sb.append(str);
        }
        System.out.println("Concatenated String : " + sb.toString());
    }
}
