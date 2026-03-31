import java.util.Scanner;

public class UniqueStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //taking input string from the user
        System.out.print("Enter a string: ");
        String Str = sc.nextLine();
        // Find length without using length()
        int Num = 0;
        try {
            while (true) {
                Str.charAt(Num);
                Num++;
            }
        } catch (IndexOutOfBoundsException e) {}
        // Find unique characters
        char[] Temp = new char[Num];
        int Unique_Count = 0;

        for (int i = 0; i < Num; i++) {
            char Ch = Str.charAt(i);
            boolean Is_Unique = true;

            for (int j = 0; j < i; j++) {
                if (Str.charAt(j) == Ch) {
                    Is_Unique = false;
                    break;
                }
            }

            if (Is_Unique) {
                Temp[Unique_Count] = Ch;
                Unique_Count++;
            }
        }
        // Print unique characters
        System.out.print("Unique characters are: ");
        for (int i = 0; i < Unique_Count; i++) {
            System.out.print(Temp[i] + " ");
        }
    }
    
}
