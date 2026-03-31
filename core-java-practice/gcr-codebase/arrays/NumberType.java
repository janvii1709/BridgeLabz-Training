import java.util.*;
public class NumberType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // taking input from user
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        // checking for the number entered is a natural number or not
        if (number <= 0){
            System.out.println("Error: Please enter a natural number");
            return;
        }
        // creating array for odd and even numbers to store
        int[] Even = new int[number/ 2 + 1];
        int[] Odd = new int[number / 2 + 1];
        // Now taking the index variables for both the even and odd arrays
        int EVENINDEX = 0;
        int ODDINDEX = 0;
        // now storing odd and even numbers in the array
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                Even[EVENINDEX] = i;
                EVENINDEX++;
            } else {
                Odd[ODDINDEX] = i;
                ODDINDEX++;
            }
        }
        //printing the odd numbers array
        System.out.println("Odd Numbers:");
        for (int i = 0; i < ODDINDEX; i++) {
            System.out.print(Odd[i] + " ");
        }
        //printing the even numbers array
        System.out.println("\nEven Numbers:");
        for (int i = 0; i < EVENINDEX; i++) {
            System.out.print(Even[i] + " ");
        }
    }
}
