import java.util.*;
public class Comparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Ages of the three friends
        int AmarAge = sc.nextInt();// amar's age input from user
        int AkbarAge = sc.nextInt();// akbar's age input from user
        int AnthonyAge = sc.nextInt();// Anthony's age input from user
        // Heights of the three friends
        int AmarHeight = sc.nextInt(); //amar's height input from user
        int AkbarHeight = sc.nextInt();//akbar's height input from user
        int AnthonyHeight = sc.nextInt();// anthony's height input from user
        // Youngest of the three 
        if (AmarAge < AkbarAge && AmarAge < AnthonyAge) {
            System.out.println("Amar is the youngest");
        } else if (AkbarAge < AnthonyAge) {
            System.out.println("Akbar is the youngest");
        } else {
            System.out.println("Anthony is the youngest");
        }
        // Tallest of the three
        if (AmarHeight > AkbarHeight && AmarHeight > AnthonyHeight) {
            System.out.println("Amar is the tallest");
        } else if (AkbarHeight > AnthonyHeight) {
            System.out.println("Akbar is the tallest");
        } else {
            System.out.println("Anthony is the tallest");
        }
    }
}
