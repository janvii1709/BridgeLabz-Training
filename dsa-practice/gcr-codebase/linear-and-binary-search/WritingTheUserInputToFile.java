import java.io.*;
public class WritingTheUserInputToFile {
    public static void main(String[] args) {
        //Taking the InputStreamReader to read input from console
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        //Taking fileWriter to write the input to file
        FileWriter fw = null;
        try {
            // The File where input will be stored
            // Here true = append mode
            fw = new FileWriter("output.txt", true); 
            System.out.println("Enter text (type 'exit' to stop):");
            String line;
            // Reading the input until user types "exit"
            while (true) {
                line = br.readLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                // Writing the each line to file
                fw.write(line + System.lineSeparator());
            }
            System.out.println("Input successfully written to file.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (fw != null) fw.close();
                br.close();
            } catch (IOException e) {
                System.out.println("Error closing resources.");
            }
        }
    }
}
