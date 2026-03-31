import java.util.*;
public class QuotientRem {
    public static int[] CalculateQuotientRem(int Num1 , int Num2){
         int Quotient = Num1 / Num2;
        int Remainder = Num1 % Num2;
        return new int[] {Quotient , Remainder};

        // System.out.println("Quotient is: " + Quotient);
        // System.out.println("Remainder is: " + Remainder);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // take input from user
        System.out.print("Enter the First Number : ");
        int Num1 = sc.nextInt();
        System.out.print("Enter the Second Number : ");
        int Num2 = sc.nextInt();

        int[] arr = CalculateQuotientRem(Num1, Num2);
        System.out.println("Quotient is: " + arr[0]);
        System.out.println("Remainder is: " + arr[1]);


    }
}
