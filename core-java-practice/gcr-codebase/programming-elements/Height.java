import java.util.*;
class Height {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input scanner
        int height = sc.nextInt();// taking height in cm as input
        double heightInInches = height / 2.54 ; // conversion of cm to inches
        double heightInFeets = heightInInches / 12 ; // conversion of inches to feets
        System.out.println("Your height in cm is " + height + " while in feet is " + heightInFeets + " and inches is " + heightInInches);

    }
}