//FIND FACTORIAL OF A NUMBER

import java.util.Scanner;
class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac = fac * i;
        }
        System.out.println("Factorial = " + fac);
    }
}
