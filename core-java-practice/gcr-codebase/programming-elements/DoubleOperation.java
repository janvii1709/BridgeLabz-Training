import java.util.*;
class DoubleOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input scanner
        double a = sc.nextDouble();// first input number
        double b = sc.nextDouble();// second input number
        double c = sc.nextDouble();// third input number
        double res1 = a + b * c;// performing operations
        double res2 = a * b + c;// performing operations
        double res3 = c + a / b;// performing operations
        double res4 = a % b + c; // performing operations
        System.out.println("The results of the operations are " + res1 + " , " + res2 + " , " + res3 + " and " + res4);
        
    }
    
}
