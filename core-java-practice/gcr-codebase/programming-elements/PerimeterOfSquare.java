import java.util.*;
class PerimeterOfSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input scanner
        double perimeter= sc.nextDouble();// taking perimeter as input
        double side = perimeter / 4; // calculating side length
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
    }
    
}
