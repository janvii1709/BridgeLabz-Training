import java.util.*;
public class CheckLargestOfTheThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input from user
        // input three numbers from user
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        // checking which number is the largest
        if (n1 > n2 && n1 > n3){
            System.out.println("\"Is the first number the largest? \"+ \"Yes\"");
        }
        else if (n2> n1 && n2 > n3) 
            {
            System.out.println("\"Is the second number the largest? \" + \"Yes\"");
            }
        else {
            System.out.println("\"Is the third number the largest? \" + \"Yes\"");
        }
    }
    
}
