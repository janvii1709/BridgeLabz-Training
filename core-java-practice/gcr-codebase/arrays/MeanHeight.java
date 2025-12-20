import java.util.*;
public class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // creating a array of size 11
        double[] Heights = new double[11];
        double SUM = 0.0; //initialzing sum as 0.0 for further calculation
        //taking input for Heights of the players IN Centimeter
        for(int i = 0 ; i < Heights.length; i++){
            System.out.print("Enter the height of player " + (i + 1) + " : " );
            Heights[i] = sc.nextDouble();
            SUM = SUM + Heights[i];
        }
        //calculating the mean now of the players using the formula
        double MEAN = SUM / Heights.length;
        // now displaying the result
        System.out.println("Mean height of the football team = " + MEAN  + " cm " );
    }
    
}
