import java.io.*;
import java.util.Scanner;
public class BufferedVsUnbufferedCopy {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.print("Enter source file path: ");
        String source = sc.nextLine();
        System.out.print("Enter destination file (unbuffered): ");
        String dest1 = sc.nextLine();
        System.out.print("Enter destination file (buffered): ");
        String dest2 = sc.nextLine();
        try {
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(dest1);
            byte[] buffer = new byte[4096];
            int bytesRead;
            long startTime = System.nanoTime();
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            long endTime = System.nanoTime();
            long unbufferedTime = endTime - startTime;
            fis.close();
            fos.close();
            System.out.println("\nUnbuffered copy time: " + unbufferedTime + " ns");
        } catch (IOException e) {
            System.out.println("Error in unbuffered copy: " + e.getMessage());
        }
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest2));
            byte[] buffer = new byte[4096];
            int bytesRead;
            long startTime = System.nanoTime();
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.flush(); 
            long endTime = System.nanoTime();
            long bufferedTime = endTime - startTime;
            bis.close();
            bos.close();
            System.out.println("Buffered copy time:   " + bufferedTime + " ns");
        } catch (IOException e) {
            System.out.println("Error in buffered copy: " + e.getMessage());
        }
    }
}
