import java.util.*;
public class MultiplicationTableOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter a number: ");
        int number = sc.nextInt(); // taking number from the user
        // defining array to store the multiplication results
        int[] TABLE = new int[10];
        // storing the multiplication results in array
        for(int i =1; i <= 10 ; i++){
            TABLE[i - 1] = number * i;

        }
        // showing yhe multiplication table of the number given by the user
        for ( int i = 1 ; i <= 10 ; i++){
            System.out.println(number + " * " + i + " = " + TABLE[i - 1]);
        }
    }
    
}
