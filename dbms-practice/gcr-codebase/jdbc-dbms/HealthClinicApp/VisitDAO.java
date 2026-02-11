import java.sql.*;
import java.util.Scanner;

public class VisitDAO {

    public static void recordVisit(Scanner x) {
        try {
            Connection con = DBConnection.getConnection();
            con.setAutoCommit(false);

            System.out.println("Enter Appointment ID:");
            int aid = x.nextInt();
            x.nextLine();

            System.out.println("Enter Diagnosis:");
            String diagnosis = x.nextLine();

            System.out.println("Enter Notes:");
            String notes = x.nextLine();

            String visitSql = "INSERT INTO visits(appointment_id,diagnosis,notes) VALUES(?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(visitSql);
            ps1.setInt(1, aid);
            ps1.setString(2, diagnosis);
            ps1.setString(3, notes);
            ps1.executeUpdate();

            String updateSql = "UPDATE appointments SET status='COMPLETED' WHERE appointment_id=?";
            PreparedStatement ps2 = con.prepareStatement(updateSql);
            ps2.setInt(1, aid);
            ps2.executeUpdate();

            con.commit();
            System.out.println("Visit Recorded Successfully");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
