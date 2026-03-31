import java.util.*;
public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // input from user
        int month = sc.nextInt(); // read month number
        int day = sc.nextInt(); // read day number
        // checking if the date and month fall in spring season
        if ((month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <=30) || (month == 5 && day >= 1 && day <= 31)) {
            System.out.println("Its a Spring Season");
        } else{
            System.out.println("Its not a Spring Season");
        }
    }
}
