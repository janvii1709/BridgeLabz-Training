import java.util.*;
public class OddEvenArr {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        // Define array of 5 elements
        int[] numb = new int[5];
        // Take user input
        for (int i = 0; i < numb.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numb[i] = sc.nextInt();
        }
        // Check each number
        for (int i = 0; i < numb.length; i++) {// checking if the number is positive
            if (numb[i] > 0) {
                if (numb[i] % 2 == 0) {
                    System.out.println(numb[i] + " is Positive and Even");
                } else {
                    System.out.println(numb[i] + " is Positive and Odd");
                }
                // checking if number is not positive
            } else if (numb[i] < 0) {
                System.out.println(numb[i] + " is Negative");
            } else {
                System.out.println(numb[i] + " is Zero");
            }
        }
        // Comparing first and last elementb of the array
        if (numb[0] == numb[numb.length - 1]) {
            System.out.println("First and Last elements are Equal");
        } else if (numb[0] > numb[numb.length - 1]) {
            System.out.println("First element is Greater than Last element");
        } else {
            System.out.println("First element is Less than Last element");
        }
    }
    
}
