import java.util.Scanner;
public class CharArrCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take string input from user
        System.out.print("Enter the string: ");
        String Text = sc.next();
        // Return characters without the use of toCharArray()
        // Creating the  character array manually
        char[] User_Arr = new char[Text.length()];
        // Store each character using charAt()
        for (int i = 0; i < Text.length(); i++) {
            User_Arr[i] = Text.charAt(i);
        }
        // Return characters using the  toCharArray()
        char[] Built_In_Array = Text.toCharArray();
        // Comparing both character arrays
        boolean Is_Equal = true;
        // Length checking
        if (User_Arr.length != Built_In_Array.length) {
            Is_Equal = false;
        } else {
            // Compare each character
            for (int i = 0; i < User_Arr.length; i++) {
                if (User_Arr[i] != Built_In_Array[i]) {
                    Is_Equal = false;
                    break;
                }
            }
        }
        // Displaying the characters and result
        System.out.print("Characters using user logic: ");
        for (char C : User_Arr) {
            System.out.print(C + " ");
        }
        System.out.println();
        System.out.print("Characters using toCharArray(): ");
        for (char C :Built_In_Array) {
            System.out.print(C + " ");
        }
        System.out.println();
        System.out.println("Are both character arrays equal? " + Is_Equal);
    }
}
