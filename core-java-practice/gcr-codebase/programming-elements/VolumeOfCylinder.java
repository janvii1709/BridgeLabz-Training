import java.util.Scanner;
class VolumeOfCylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input scanner
        System.out.print("Enter radius: ");// taking radius as input
        double radius = sc.nextDouble();// taking radius as input
        System.out.print("Enter height: ");// taking height as input
        double height = sc.nextDouble();// taking height as input
        double volume = Math.PI * radius * radius * height;// volume calculation 
        System.out.println("Volume of the cylinder = " + volume);
    }
}
