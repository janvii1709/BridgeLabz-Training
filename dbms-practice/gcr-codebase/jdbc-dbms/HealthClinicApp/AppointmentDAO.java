import java.sql.*;
import java.util.Scanner;

public class AppointmentDAO {

    public static void bookAppointment(Scanner sc) {
        try {
            Connection con = DBConnection.getConnection();

            System.out.println("Enter Patient ID:");
            int patientId = sc.nextInt();

            System.out.println("Enter Doctor ID:");
            int doctorId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Appointment Date (YYYY-MM-DD):");
            String date = sc.nextLine();

            String query = "INSERT INTO appointments(patient_id, doctor_id, date) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, patientId);
            ps.setInt(2, doctorId);
            ps.setString(3, date);

            ps.executeUpdate();
            System.out.println("Appointment Booked Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
