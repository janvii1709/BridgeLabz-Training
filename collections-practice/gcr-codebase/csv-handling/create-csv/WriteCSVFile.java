import java.io.FileWriter;
import java.io.IOException;
public class WriteCSVFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("employees.csv");
            // Writing header
            writer.write("ID,Name,Department,Salary\n");
            // Writing employee records
            writer.write("1,Rahul,IT,50000\n");
            writer.write("2,Priya,HR,45000\n");
            writer.write("3,Amit,Finance,60000\n");
            writer.write("4,Neha,Marketing,48000\n");
            writer.write("5,Karan,Operations,52000\n");
            writer.close();
            System.out.println("Employee data written successfully into CSV file.");
        } catch (IOException e) {
            System.out.println("Error while writing data to CSV file.");
        }
    }
}
