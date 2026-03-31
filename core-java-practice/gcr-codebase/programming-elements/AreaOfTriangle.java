import java.util.*;
class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();// taking base as input
        double height = sc.nextDouble();// taking height as input
        double areaInSqInches = 0.5 * base * height;// area calculation in square inches
        double areaInSqCm = areaInSqInches * 2.54 * 2.54 ;// conversion to square cm
        System.out.println("The Area in square cm is " + areaInSqCm + " while area in square inches is " + areaInSqInches);


    }
    
}
