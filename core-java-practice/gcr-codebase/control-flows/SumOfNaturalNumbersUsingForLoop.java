import java.util.*;
class SumOfNaturalNumbersUsingForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // input a number from user
        // check if the number is natural number
        if (n <= 0 ){
            System.out.println("Please enter a valid natural number(greater than 0)");
        } else {
            // sum using for loop
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println("sum using for loop is : " + sum); // print sum using for loop
            // sum using formula
            int sum2 = n * (n + 1) / 2 ; // formula to calculate sum of first n natural numbers
            System.out.println("Sum using formula is : " + sum2); //print sum using formula
            // now we will compare both the sums
            if ( sum == sum2){
                System.out.println("Both the results are correct and equal");

            }
            else {
                System.out.println("Both the results are not correct and equal");
            }

        }
    }
    
}
