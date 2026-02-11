import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- HEALTH CLINIC SYSTEM ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. Generate Bill");
            System.out.println("5. Record Visit");
            System.out.println("6. Exit");
            System.out.println("Enter choice:");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    PatientDAO.addPatient(sc);
                    break;

                case 2:
                    DoctorDAO.addDoctor(sc);
                    break;

                case 3:
                    AppointmentDAO.bookAppointment(sc);
                    break;

                case 4:
                    BillingDAO.generateBill(sc);
                    break;

                case 5:
                    VisitDAO.recordVisit(sc);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
