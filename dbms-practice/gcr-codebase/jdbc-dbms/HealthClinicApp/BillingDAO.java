import java.sql.*;
import java.util.Scanner;

public class BillingDAO {

    public static void generateBill(Scanner x) {
        try {
            Connection con = DBConnection.getConnection();

            System.out.println("Enter Visit ID:");
            int vid = x.nextInt();

            System.out.println("Enter Total Amount:");
            double amount = x.nextDouble();

            String sql = "INSERT INTO bills(visit_id,total_amount,payment_status) VALUES(?,?,'UNPAID')";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, vid);
            ps.setDouble(2, amount);

            ps.executeUpdate();
            System.out.println("Bill Generated");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
