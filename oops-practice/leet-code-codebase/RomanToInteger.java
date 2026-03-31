import java.util.*;
public class RomanToInteger {
    // Method to get value of Roman character
    public static int GetValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static int RomanToInt(String str) {
        int Res = 0;

        for (int i = 0; i < str.length(); i++) {
            int current = GetValue(str.charAt(i));

            // check subtraction case
            if (i + 1 < str.length() && current < GetValue(str.charAt(i + 1))) {
                Res -= current;
            } else {
                Res += current;
            }
        }

        return Res;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roman Numeral: ");
        String str = sc.nextLine();

        int ans = RomanToInt(str);
        System.out.println("Integer value: " + ans);
    }
}
