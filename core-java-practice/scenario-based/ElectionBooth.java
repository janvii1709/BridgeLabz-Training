import java.util.*;
public class ElectionBooth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age;
        while (true) { 
            System.out.print("Enter age or press -1 to exit ");
            age = sc.nextInt();
            if (age == -1){
                System.out.println("Voting closed.Invalid ! ");
                break;
            }
            if (age >= 18) {
                System.out.println("You are eligible to vote.");
                System.out.print("Vote for candidate (1 / 2 / 3): ");
                int vote = sc.nextInt();

                if (vote == 1 || vote == 2 || vote == 3) {
                    System.out.println("Vote recorded successfully.");
                } else {
                    System.out.println("Invalid vote.");
                }

            } else {
                System.out.println("You are not eligible to vote.");
            }
        }
    }
}

