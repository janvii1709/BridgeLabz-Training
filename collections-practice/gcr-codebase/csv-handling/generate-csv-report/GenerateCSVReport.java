import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class GenerateCSVReport {
    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/company"; // DB URL
        String username = "root";      // Replace with your DB username
        String password = "password";  // Replace with your DB password
        String csvFile = "employee_report.csv"; // Output CSV file

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "SELECT employee_id, name, department, salary FROM employees");
                 FileWriter fw = new FileWriter(csvFile)) {

                // Write CSV header
                fw.append("Employee ID,Name,Department,Salary\n");

                // Write data rows
                while (rs.next()) {
                    fw.append(rs.getInt("employee_id") + ",");
                    fw.append(rs.getString("name") + ",");
                    fw.append(rs.getString("department") + ",");
                    fw.append(rs.getDouble("salary") + "\n");
                }

                System.out.println("CSV report generated successfully: " + csvFile);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include the connector JAR in classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File writing error:");
            e.printStackTrace();
        }
    }
}
