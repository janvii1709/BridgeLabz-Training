import java.io.*;
import java.util.Scanner;
public class FileReadWrite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source file name: ");
        String sourceFile = sc.nextLine();
        System.out.print("Enter destination file name: ");
        String destFile = sc.nextLine();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File(sourceFile);
            if (!file.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }
}
