import java.sql.*;
import java.util.Scanner;

public class DoctorDAO {

    public static void addDoctor(Scanner x) {
        try {
            Connection con = DBConnection.getConnection();

            System.out.println("Enter Doctor Name:");
            String name = x.nextLine();

            System.out.println("Enter Specialty ID:");
            int spId = x.nextInt();

            System.out.println("Enter Contact:");
            x.nextLine();
            String contact = x.nextLine();

            System.out.println("Enter Consultation Fee:");
            double fee = x.nextDouble();

            String sql = "INSERT INTO doctors(name,specialty_id,contact,consultation_fee) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, spId);
            ps.setString(3, contact);
            ps.setDouble(4, fee);

            ps.executeUpdate();
            System.out.println("Doctor Added Successfully");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
