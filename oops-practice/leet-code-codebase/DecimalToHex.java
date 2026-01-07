import java.util.*;
public class DecimalToHex {
    public static String toHex(int num){
        if(num == 0){
            return "0";
    }
    char [] hex = "0123456789abcdef".toCharArray();
    StringBuilder res = new StringBuilder();
    while(num != 0){
        int dig = num & 15;
        res.append(hex[dig]);
        num >>>= 4;
        int digit = num & 15;
        res.append(hex[digit]);
        num >>>= 4;
    }
    return res.reverse().toString();

}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter an integer ");
    int num = sc.nextInt();
    System.out.println("Hexadecimal: " + toHex(num));
}
}