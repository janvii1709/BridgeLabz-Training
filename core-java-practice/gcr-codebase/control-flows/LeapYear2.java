import java.util.*;
public class LeapYear2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt(); // input year from user
        // check for leap year using single if condition
        if (year >= 1582 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))){// Gregorian calendar started from 1582 then check  for leap year by dividing the year  by 400 , 4 and 100.
            System.out.println("Is a leap year");// print leap year
        }
        else{
            System.out.println("Is not a leap year");// print not leap year
        }
    }
    
}
