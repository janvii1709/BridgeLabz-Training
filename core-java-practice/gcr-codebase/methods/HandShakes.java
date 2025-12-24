import java.util.Scanner;

public class HandShakes {
    public static int CalculateHandShakes(int numberOfStudents){
        return (numberOfStudents *(numberOfStudents - 1)) / 2 ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // taking input from user
        System.out.print("Enter the number of students : ");
        int numberOfStudents = sc.nextInt();
        int HandShakes = CalculateHandShakes(numberOfStudents);
        System.out.println("The Number Of Possible HandShakes is : " + HandShakes);
    }

    
}
