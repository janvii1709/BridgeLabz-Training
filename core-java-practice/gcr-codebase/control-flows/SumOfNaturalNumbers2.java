import java.util.*;
class SumofNaturalNumbers2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // input a number from user
        // check if the number is natural number
        if (n <= 0){
            System.out.println("Please enter a valid natural number(greater than 0)");
        } else{
            // sum using while loop
            int sum = 0;// initialize sum variable
            int i = 1;// initialize counter variable 
            while(i <= n){
                sum += i;
                i++;
            }
            // sum using formula 
            int sum2 = n * (n + 1) / 2; // formula to calculate sum of first n natural numbers
            System.out.println("Sum using while loop : " + sum);// print sum using while loop
            System.out.println("Sum using Formula : " + sum2);// print sum using formula
            // now we will compare both the sums 
            if (sum == sum2){
                System.out.println("Both results are correct and equal ");
            }
            else{
                System.out.println("Both results are not equal and correct");
            }
        }


        }
    }
