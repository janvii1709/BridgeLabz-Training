import java.util.Scanner;
class KilometersToMiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input scanner
        System.out.print("Enter distance in kilometers: ");
        double km = sc.nextDouble();//taking input in kilometers
        double miles = km * 0.621371;// conversion formula 
        System.out.println("Distance in miles = " + miles);
        sc.close();
    }
}
