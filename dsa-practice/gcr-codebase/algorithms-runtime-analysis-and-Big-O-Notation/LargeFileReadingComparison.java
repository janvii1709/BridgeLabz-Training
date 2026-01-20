import java.io.*;
import java.util.Scanner;
public class LargeFileReadingComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking the file path input from user
        System.out.print("Enter the full path of the file to read: ");
        String filePath = sc.nextLine();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist. Please check the path!");
            return;
        }

        try {
            // FileReader
            long start = System.nanoTime();
            FileReader fr = new FileReader(file);
            while (fr.read() != -1) {
                // Reading character by character
            }
            fr.close();
            long end = System.nanoTime();
            double fileReaderTime = (end - start) / 1_000_000.0;
            System.out.printf("FileReader Time: %.5f ms\n", fileReaderTime);

            // InputStreamReader
            start = System.nanoTime();
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            while (isr.read() != -1) {
                // Reading byte by byte and converting to char
            }
            isr.close();
            end = System.nanoTime();
            double inputStreamReaderTime = (end - start) / 1_000_000.0;
            System.out.printf("InputStreamReader Time: %.5f ms\n", inputStreamReaderTime);

            //Comparing the result now
            System.out.println("\nExpected Result:");
            System.out.println("InputStreamReader is more efficient for large files.");
            System.out.println("FileReader is preferable for text-based data and smaller files.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
