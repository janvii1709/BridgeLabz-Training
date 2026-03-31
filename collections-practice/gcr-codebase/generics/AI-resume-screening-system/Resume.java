
public class Resume<T extends JobRole> {
    private T applicant;

    public Resume(T applicant) {
        this.applicant = applicant;
    }

    public void screenResume() {
        System.out.println("\nScreening resume of: " + applicant.getName());
        System.out.println("Experience: " + applicant.getExperience() + " years");
        applicant.requiredSkills();
        System.out.println("Screening completed.\n");
    }

    public T getApplicant() {
        return applicant;
    }
}
