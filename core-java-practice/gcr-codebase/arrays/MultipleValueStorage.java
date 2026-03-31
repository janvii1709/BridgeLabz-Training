import java.util.*;
public class MultipleValueStorage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // creating the array and the variables
        double[] num = new double[10];
        double Total = 0.0 ;// taking total initialized to 0.0
        int Index = 0;// index initialized to 0
        // applying infinite loop
        while (true) {
            System.out.print("Enter a number: ");
            double Input = sc.nextDouble();
            //Break if input is 0 or r=negative
            if ( Input <= 0){
                break;
            } 
            //Break if the array size reaches 10
            if ( Index == 10){
                break;
            }
            // storing value in array
            num[Index] = Input;
            Index++; // incrementing the value of index
        }
            // calculating the sum now
            System.out.println("Entered numbers: ");
            for(int i= 0 ; i < Index ; i++){
                System.out.println(num[i]);
                Total = Total + num[i];

            }
            System.out.println("Total sum = " + Total);
        }
    }
