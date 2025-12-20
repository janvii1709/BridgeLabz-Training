import java.util.*;
public class MultiplicationOfNumberFrom6To9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Taking input from user now
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        // array to store the multiplication of the number 
        int[] MultiRes = new int[4]; // for 6,7,8,9 only thats why 4
        int Index = 0;
        // calculating multiplication table from 6 to 9
        for (int i = 6 ; i <= 9 ; i++){
            MultiRes[Index] = num * i ;
            Index++;
        }
        // now displaying the output of the multiplication
        Index = 0;
        for(int i = 6 ; i <= 9 ; i++){
            System.out.println(num + " * " + i + " = " + MultiRes[Index]);
            Index++;
        }

    }
    
}
