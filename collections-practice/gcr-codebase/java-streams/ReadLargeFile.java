import java.io.*;
import java.util.Scanner;
public class ReadLargeFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the path of the large text file: ");
        String filename = sc.nextLine();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                    count++;
                }
            }
            System.out.println("\nTotal lines containing 'error': " + count);
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Error closing BufferedReader.");
            }
        }
    }
}
