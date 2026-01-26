import java.io.*;
import java.util.Scanner;
public class ImageByteArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source image file path (e.g., image.jpg): ");
        String sourceFile = sc.nextLine();
        System.out.print("Enter destination image file path (e.g., copy.jpg): ");
        String destFile = sc.nextLine();
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        ByteArrayInputStream bais = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourceFile);
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = baos.toByteArray();
            System.out.println("Image successfully read into byte array. Size: " + imageBytes.length + " bytes");
            bais = new ByteArrayInputStream(imageBytes);
            fos = new FileOutputStream(destFile);
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Image successfully written to " + destFile);
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (baos != null) baos.close();
                if (bais != null) bais.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing streams.");
            }
        }
    }
}
