import java.util.*;
public class DaysOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Command-line arguments
        System.out.println("Enter the Month ");
        int month = sc.nextInt();
        System.out.println("Enter the Day ");
        int day = sc.nextInt();
        System.out.println("Enter the Year ");
        int year = sc.nextInt();
        //Applying formula given in the question
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + (31 * m0) / 12) % 7;

        System.out.println("The Day of the week is: " + d0);// printing the day now 
    }
}