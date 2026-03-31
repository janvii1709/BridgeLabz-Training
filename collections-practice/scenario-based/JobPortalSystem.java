import java.util.*;

// Custom Exception
class InvalidResumeException extends Exception {
    public InvalidResumeException(String msg) {
        super(msg);
    }
}
// Resume Class
class Resume {
    String name;
    Set<String> skills;
    int matchCount;

    Resume(String name, Set<String> skills) {
        this.name = name;
        this.skills = skills;
    }
}
public class JobPortalSystem {
    public static void main(String[] args) throws InvalidResumeException {

        Scanner sc = new Scanner(System.in);
        List<Resume> resumes = new ArrayList<>();

        System.out.print("Enter number of resumes: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0)
            throw new InvalidResumeException("No resumes found!");

        // Input resumes
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter candidate name: ");
            String name = sc.nextLine();
            System.out.print("Enter number of skills: ");
            int skillCount = sc.nextInt();
            sc.nextLine();
            Set<String> skills = new HashSet<>();
            for (int j = 0; j < skillCount; j++) {
                System.out.print("Enter skill: ");
                skills.add(sc.nextLine().toLowerCase());
            }
            resumes.add(new Resume(name, skills));
        }
        // Required skills
        System.out.print("\nEnter required skills count: ");
        int r = sc.nextInt();
        sc.nextLine();
        Set<String> requiredSkills = new HashSet<>();
        for (int i = 0; i < r; i++) {
            System.out.print("Enter required skill: ");
            requiredSkills.add(sc.nextLine().toLowerCase());
        }
        // Match calculation
        for (Resume res : resumes) {
            int count = 0;
            for (String skill : res.skills) {
                if (requiredSkills.contains(skill))
                    count++;
            }
            res.matchCount = count;
        }
        // Sorting using Comparator
        resumes.sort((a, b) -> b.matchCount - a.matchCount);

        System.out.println("\n--- Ranked Resumes ---");
        for (Resume r1 : resumes) {
            System.out.println(r1.name + " | Matching Skills: " + r1.matchCount);
        }
    }
}
