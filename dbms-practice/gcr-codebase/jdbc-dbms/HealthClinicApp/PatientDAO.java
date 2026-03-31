import java.sql.*;
import java.util.Scanner;

public class PatientDAO {

    public static void addPatient(Scanner sc) {
        try {
            Connection con = DBConnection.getConnection();

            System.out.println("Enter Name:");
            String name = sc.nextLine();

            System.out.println("Enter Phone:");
            String phone = sc.nextLine();

            String query = "INSERT INTO patients(name, phone) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);

            ps.executeUpdate();
            System.out.println("Patient Added Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
