import java.util.*;
public class Divisible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// Input from user
        int n = sc.nextInt();// Read a number
        // loop to check divisibility by 5
        if ( n % 5 == 0) {
            System.out.println("Is the number " + n + " divisible by 5? Yes");
        }
        else {
            System.out.println("Is the number " + n + " divisible by 5? No");
        }
    }
}