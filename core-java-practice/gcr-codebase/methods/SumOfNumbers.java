import java.util.*;
public class SumOfNumbers {
    public static int CalculateSumOfNaturalNumbers(int Num){
        int sum = 0 ;
        for(int i = 1 ; i <= Num ; i++){
            sum = sum + i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // taking input from user
        System.out.print("Enter the Number : ");
        int Num = sc.nextInt();
        int Output = CalculateSumOfNaturalNumbers(Num);
        System.out.println("The sum of N natural Numbers is : " + Output);
    }
    
}
