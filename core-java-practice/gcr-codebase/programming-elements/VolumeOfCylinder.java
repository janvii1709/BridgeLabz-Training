import java.util.Scanner;
class VolumeOfCylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input radius and height
        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();
        System.out.print("Enter height: ");
        double height = sc.nextDouble();
        // Calculate volume
        double volume = Math.PI * radius * radius * height;
        // Output
        System.out.println("Volume of the cylinder = " + volume);
        sc.close();
    }
}
