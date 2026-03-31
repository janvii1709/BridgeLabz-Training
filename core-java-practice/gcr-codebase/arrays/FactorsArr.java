import java.util.*;
public class FactorsArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        // Initial array size
        int maxFactor = 10;
        int[] Fact = new int[maxFactor];
        int INDEX = 0;
        // Finding factors of the given number
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // Resize array if the array is full
                if (INDEX == maxFactor) {
                    maxFactor = maxFactor * 2;
                    int[] temp = new int[maxFactor];

                    for (int j = 0; j < Fact.length; j++) {
                        temp[j] = Fact[j];
                    }
                    Fact = temp;
                }
                Fact[INDEX] = i;
                INDEX++;
            }
        }
        //displaying the factors of the number
        System.out.println("Factors of " + number + " are:");
        for (int i = 0; i < INDEX; i++) {
            System.out.print(Fact[i] + " ");
        }
    }
    
}
