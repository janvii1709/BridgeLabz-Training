import java.sql.*;
import java.util.Scanner;

public class DoctorDAO {

    public static void addDoctor(Scanner sc) {
        try {
            Connection con = DBConnection.getConnection();

            System.out.println("Enter Doctor Name:");
            String name = sc.nextLine();

            System.out.println("Enter Specialization:");
            String specialization = sc.nextLine();

            String query = "INSERT INTO doctors(name, specialization) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, specialization);

            ps.executeUpdate();
            System.out.println("Doctor Added Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
