import java.util.*;
class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();
        double height = sc.nextDouble();
        double areaInSqInches = 0.5 * base * height;
        double areaInSqCm = areaInSqInches * 2.54 * 2.54 ;
        System.out.println("The Area in square cm is " + areaInSqCm + " while area in square inches is " + areaInSqInches);


    }
    
}
