import java.util.*;
class DistanceInYardsAndMiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double distanceInFeets = sc.nextDouble();
        double distanceInYards = distanceInFeets / 3;// 1 yard = 3 feet
        double DistanceInMiles = distanceInYards / 1760 ; // 1 mile = 1760 yards
        System.out.println("The distance in feets is " + distanceInFeets + " while in yards is " + distanceInYards + " and in miles is " + DistanceInMiles);
    }
    
}
