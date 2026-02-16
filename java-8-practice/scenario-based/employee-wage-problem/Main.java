import java.util.*;
public class Main{
    public static void main(String[] args) {
        System.out.println("Welcome To Employee Wage Computation Program ");
        int wagerPerHour = 20;
        int fullDayHours = 8;
        Random random = new Random();
        int attendance = random.nextInt(2);// 0 or 1
        if(attendance == 1){
            System.out.println("Employee is Present");
            int dailyWage = wagerPerHour * fullDayHours;
            System.out.println("Daily Employee Wage : INR " +dailyWage);
        }
        else{
            System.out.println("Employee is Absent");
            System.out.println("Daily Employee Wage : INR 0 ");
        }
    }
}