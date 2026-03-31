import java.util.*;
public class SmallestLargest {
    public static int[] FindLargestSmallest(int Num1 , int Num2 , int Num3){

        int Smallest = Num1;
        int Largest = Num1;
        if (Num2 < Smallest) {
            Smallest = Num2;
        }
        if (Num3 < Smallest) {
            Smallest = Num3;
        }
        if (Num2 > Largest) {
            Largest = Num2;
        }
        if (Num3 > Largest) {
            Largest = Num3;
        }
        return new int[] {Largest , Smallest};
        // System.out.println("Smallest number is: " + Smallest);
        // System.out.println("Largest number is: " + Largest);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking input
        System.out.print("Enter first number: ");
        int Num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int Num2 = sc.nextInt();
        System.out.print("Enter third number: ");
        int Num3 = sc.nextInt();

        int [] arr =FindLargestSmallest(Num1, Num2, Num3);
        System.out.println("Smallest number is: " + arr[1]);
        System.out.println("Largest number is: " + arr[0]);

    }
}
