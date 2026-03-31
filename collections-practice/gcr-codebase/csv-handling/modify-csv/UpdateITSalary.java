import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class UpdateITSalary {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
        FileWriter fw = new FileWriter(outputFile)) {
            String line;
            // Read header and write to output file
            line = br.readLine();
            if (line != null) {
                fw.write(line + "\n");
            }
            // Process each employee record
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String department = data[2];
                double salary = Double.parseDouble(data[3]);
                // Increase salary by 10% if department is IT
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary + (salary * 0.10);
                }
                // Write updated record to new CSV
                fw.write(data[0] + "," + data[1] + "," + department + "," + (int)salary + "\n");
            }
            System.out.println("Updated CSV file saved as: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error reading/writing CSV file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV file.");
        }
    }
}
