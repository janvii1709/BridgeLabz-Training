import java.io.*;
import java.util.Scanner;
public class UpperToLowerFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source file name (with path if needed): ");
        String sourceFile = sc.nextLine();
        System.out.print("Enter destination file name: ");
        String destFile = sc.nextLine();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(sourceFile));
            bw = new BufferedWriter(new FileWriter(destFile));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
            System.out.println("File converted to lowercase successfully.");
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.out.println("Error closing streams.");
            }
        }
    }
}
