import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- HEALTH CLINIC SYSTEM ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. Record Visit");
            System.out.println("5. Generate Bill");
            System.out.println("6. Exit");

            System.out.println("Enter Choice:");
            int ch = x.nextInt();
            x.nextLine();

            switch (ch) {
                case 1: PatientDAO.registerPatient(x); break;
                case 2: DoctorDAO.addDoctor(x); break;
                case 3: AppointmentDAO.bookAppointment(x); break;
                case 4: VisitDAO.recordVisit(x); break;
                case 5: BillingDAO.generateBill(x); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid Choice");
            }
        }
    }
}
