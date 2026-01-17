import java.io.*;
public class ReadFileLineByLine {
    public static void main(String[] args) {
        try {
            // Creating the FileReader
            FileReader fr = new FileReader("sample.txt");
            // Wrapping the FileReader with BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String line;
            // Reading the file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            //closing the files after reading all the lines
            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
