import java.util.Scanner;
public class ArrayIndexOutOfBoundException{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take array size from the user
        System.out.print("Enter number of names: ");
        int N = sc.nextInt();
        // Declaring the array
        String[] Names = new String[N];
        // Taking the  array input
        for (int i = 0; i < N; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            Names[i] = sc.next();
        }
        // GENERATE ArrayIndexOutOfBoundsException
        System.out.println(" Generating ArrayIndexOutOfBoundsException:");
        try {
            // Accessing invalid index (greater than array length)
            System.out.println(Names[N]);   // Exception generated
        } catch (Exception e) {
            System.out.println("Exception generated, program stopped abruptly");
        }
        // Handling the ArrayIndexOutOfBoundsException
        System.out.println(" Handling Exception using try-catch:");
        try {
            // Again accessing invalid index
            System.out.println(Names[N]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
            System.out.println("Error Message: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught");
        }
    }
}
