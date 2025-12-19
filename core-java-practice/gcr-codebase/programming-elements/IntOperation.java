import java.util.*;
class IntOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // first input number
        int b = sc.nextInt(); // second input number
        int c = sc.nextInt(); // third input number
        int r1 = a + b * c;// performing operations
        int r2 = a * b + c;//performing operations
        int r3 = c + a / b;// performing operations
        int r4 = a % b + c; // performing operations
        System.out.println("The results of the operations are " + r1 + " , " + r2 + " , " + r3 + " and " + r4);
        
    }
    
}
