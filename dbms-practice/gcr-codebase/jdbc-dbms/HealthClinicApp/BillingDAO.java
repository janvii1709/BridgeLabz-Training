import java.sql.*;
import java.util.Scanner;

public class BillingDAO {

    public static void generateBill(Scanner sc) {
        try {
            Connection con = DBConnection.getConnection();

            System.out.println("Enter Appointment ID:");
            int appointmentId = sc.nextInt();

            System.out.println("Enter Amount:");
            double amount = sc.nextDouble();

            String query = "INSERT INTO billing(appointment_id, amount) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, appointmentId);
            ps.setDouble(2, amount);

            ps.executeUpdate();
            System.out.println("Bill Generated Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
