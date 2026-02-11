import java.sql.*;
import java.util.Scanner;

public class PatientDAO {

    public static void registerPatient(Scanner x) {
        try {
            Connection con = DBConnection.getConnection();

            System.out.println("Enter Patient Name:");
            String name = x.nextLine();

            System.out.println("Enter DOB (yyyy-mm-dd):");
            String dob = x.nextLine();

            System.out.println("Enter Phone:");
            String phone = x.nextLine();

            System.out.println("Enter Email:");
            String email = x.nextLine();

            System.out.println("Enter Address:");
            String address = x.nextLine();

            System.out.println("Enter Blood Group:");
            String bg = x.nextLine();

            String sql = "INSERT INTO patients(name,dob,phone,email,address,blood_group) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.setString(6, bg);

            ps.executeUpdate();
            System.out.println("Patient Registered Successfully");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
