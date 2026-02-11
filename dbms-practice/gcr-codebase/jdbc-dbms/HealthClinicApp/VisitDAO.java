import java.sql.*;
import java.util.Scanner;

public class VisitDAO {

    public static void recordVisit(Scanner sc) {
        try {
            Connection con = DBConnection.getConnection();

            System.out.println("Enter Patient ID:");
            int patientId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Visit Notes:");
            String notes = sc.nextLine();

            String query = "INSERT INTO visits(patient_id, notes) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, patientId);
            ps.setString(2, notes);

            ps.executeUpdate();
            System.out.println("Visit Recorded Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
