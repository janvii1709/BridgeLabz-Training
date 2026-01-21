
import java.util.List;

public class ResumeProcessor {
    public static void processResumes(List<? extends JobRole> resumes) {
        System.out.println("\n=== Batch Processing Resumes ===");
        for (JobRole applicant : resumes) {
            System.out.println("Processing resume for: " + applicant.getName());
            System.out.println("Experience: " + applicant.getExperience() + " years");
            applicant.requiredSkills();
            System.out.println("-----");
        }
    }
}
