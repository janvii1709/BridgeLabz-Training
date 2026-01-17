import java.io.*;
import java.util.*;
public class ReadingFileUsingInputStreamReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking the file name from the user
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        // Taking the charset from user
        System.out.print("Enter character encoding (e.g., UTF-8) : ");
        String charset = sc.nextLine();
        try {
            //Reading the bytes from file
            FileInputStream fis = new FileInputStream(fileName);

            //Converting the byte stream to character stream
            InputStreamReader isr = new InputStreamReader(fis, charset);

            //Reading the characters efficiently
            BufferedReader br = new BufferedReader(isr);
            String line;
            System.out.println("\nFile content:\n");

            //Reading the file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
