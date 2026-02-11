import java.sql.*;
import java.util.Scanner;

public class AppointmentDAO {

    public static void bookAppointment(Scanner x) {
        try {
            Connection con = DBConnection.getConnection();

            System.out.println("Enter Patient ID:");
            int pid = x.nextInt();

            System.out.println("Enter Doctor ID:");
            int did = x.nextInt();

            System.out.println("Enter Date (yyyy-mm-dd):");
            x.nextLine();
            String date = x.nextLine();

            System.out.println("Enter Time (hh:mm:ss):");
            String time = x.nextLine();

            String sql = "INSERT INTO appointments(patient_id,doctor_id,appointment_date,appointment_time,status) VALUES(?,?,?,?, 'SCHEDULED')";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, pid);
            ps.setInt(2, did);
            ps.setDate(3, Date.valueOf(date));
            ps.setTime(4, Time.valueOf(time));

            ps.executeUpdate();
            System.out.println("Appointment Booked");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
