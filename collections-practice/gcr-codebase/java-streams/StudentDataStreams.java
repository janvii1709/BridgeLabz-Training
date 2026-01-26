import java.io.*;
import java.util.Scanner;
public class StudentDataStreams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        String filename = "students.dat";
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for Student " + (i + 1));
                System.out.print("Roll Number: ");
                int roll = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("GPA: ");
                double gpa = sc.nextDouble();
                dos.writeInt(roll);
                dos.writeUTF(name);
                dos.writeDouble(gpa);
            }
            System.out.println("\nStudent details saved successfully.");
        } catch (IOException e) {
            System.out.println("IOException occurred while writing: " + e.getMessage());
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("\nStudent Details from File:");
            for (int i = 0; i < n; i++) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("IOException occurred while reading: " + e.getMessage());
        }
    }
}
