import java.util.*;
public class NumberType {
    public static int CalculateTypeOfNumber(int Number){
        if(Number > 0){
            return 1;
        }
        else if( Number < 0){
            return -1;
        }
        else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // taking input from user
        System.out.print("Enter the number : ");
        int Number = sc.nextInt();
        int TypeOfTheNumber = CalculateTypeOfNumber(Number);
        if(TypeOfTheNumber == 1){
            System.out.println("The Number Is Positive ");
        }
        else if(TypeOfTheNumber == -1){
            System.out.println("The Number Is Negative ");
        }
        else{
            System.out.println("The Number Is Zero ");
        }
    }
    
}
