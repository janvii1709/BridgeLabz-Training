import java.util.ArrayList;
import java.util.Scanner;
public class TestSuppressWarnings {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Raw ArrayList without generics
        ArrayList list = new ArrayList();
        System.out.print("How many elements do you want to add? ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        // Take user input and add to raw ArrayList
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            String element = sc.nextLine();
            list.add(element); // raw type, no generics
        }
        System.out.println("\nElements in the list:");
        for (Object obj : list) {
            System.out.println(obj);
        }
        // Demonstrate unchecked warning suppression
        System.out.println("\nAccessing first element as a String:");
        String firstElement = (String) list.get(0); // unchecked cast
        System.out.println(firstElement);
    }
}
