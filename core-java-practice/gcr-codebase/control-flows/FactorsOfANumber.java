import java.util.Scanner;
public class FactorsOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int number = sc.nextInt();// input a number from user
        if (number <= 0) {// check if a number is positive
            System.out.println("Enter a positive integer.");
        } else {
            System.out.println("Factors of " + number + " are:");
            for (int i = 1; i < number; i++) {// loop runs till i is less than the number
                if (number % i == 0) {// check if the number is completely divisible by i
                    System.out.println(i);
                }
            }
        }
        
    }
    
}
