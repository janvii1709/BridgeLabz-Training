
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AIResumeScreeningSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<JobRole> applicants = new ArrayList<>();

        System.out.print("How many applicants? ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for applicant " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Experience (years): ");
            int exp = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Job Role (SoftwareEngineer / DataScientist / ProductManager): ");
            String role = sc.nextLine();

            switch (role) {
                case "SoftwareEngineer":
                    applicants.add(new SoftwareEngineer(name, exp));
                    break;
                case "DataScientist":
                    applicants.add(new DataScientist(name, exp));
                    break;
                case "ProductManager":
                    applicants.add(new ProductManager(name, exp));
                    break;
                default:
                    System.out.println("Invalid role! Skipping applicant.");
            }
        }

        // Screen individual resumes
        for (JobRole applicant : applicants) {
            Resume<JobRole> resume = new Resume<>(applicant);
            resume.screenResume();
        }

        // Batch process all resumes
        ResumeProcessor.processResumes(applicants);
    }
}
