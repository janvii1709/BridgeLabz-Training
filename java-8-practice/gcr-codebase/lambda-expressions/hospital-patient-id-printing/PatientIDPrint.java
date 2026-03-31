import java.util.*;
public class PatientIDPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> patientIds = new ArrayList<>();
        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        System.out.println("Enter patient IDs:");
        for (int i = 0; i < n; i++) {
            patientIds.add(sc.nextInt());
        }
        System.out.println("\nPatient IDs for Admin Verification:");
        // Print all patient IDs using method reference
        patientIds.forEach(System.out::println);
    }
}
