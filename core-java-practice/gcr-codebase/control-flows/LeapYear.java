import java.util.*;
public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt(); // input year from user
        if(year< 1582){
            System.out.println("Year must be 1582 or greater");// Gregorian calendar started from 1582
        }
        else if ( year % 400 == 0){// divisibility by 400
            System.out.println("Is a leap year");// print leap year
        }
        else if ( year % 100 == 0){// divisibility by 100
            System.out.println("Is not a leap year");// print not leap year

        }
        else if (year % 4 == 0){// divisibility by 4
            System.out.println("Is a leap year");// print leap year
        }
        else {
            System.out.println("Is not a leap year");// print not leap year
        }
    }
    
}
