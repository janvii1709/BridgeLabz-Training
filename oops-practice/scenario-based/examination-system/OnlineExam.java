import java.util.*;

public class OnlineExam {

    static Scanner sc = new Scanner(System.in);
    static Exam exam;
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Online Exam Menu ---");
            System.out.println("1. Create Exam");
            System.out.println("2. Enroll Student");
            System.out.println("3. Take Exam");
            System.out.println("4. Generate Result");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    createExam();
                    break;

                case 2:
                    enrollStudent();
                    break;

                case 3:
                    takeExam();
                    break;

                case 4:
                    generateResult();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ---------------- METHODS ----------------

    static void createExam() {
        System.out.print("Enter Exam Name: ");
        String name = sc.nextLine();
        exam = new Exam(name);

        System.out.print("Enter number of questions: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter Question: ");
            String q = sc.nextLine();

            System.out.print("Enter Correct Answer: ");
            String ans = sc.nextLine();

            System.out.print("Type (OBJECTIVE/DESCRIPTIVE): ");
            String type = sc.nextLine();

            exam.addQuestion(new Question(q, ans, type));
        }
        System.out.println("Exam created successfully");
    }

    static void enrollStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        students.add(new Student(id, name));
        System.out.println("Student enrolled successfully");
    }

    static void takeExam() {
        if (exam == null || students.isEmpty()) {
            System.out.println("Create exam and enroll students first");
            return;
        }

        Student student = students.get(0); // simple demo

        for (Question q : exam.questions) {
            System.out.println(q.questionText);
            System.out.print("Answer: ");
            student.answers.add(sc.nextLine());
        }
    }

    static void generateResult() {
        System.out.println("Evaluation Type:");
        System.out.println("1. Objective");
        System.out.println("2. Descriptive");
        System.out.print("Enter choice: ");
        int ch = sc.nextInt();

        EvaluationStrategy strategy;
        if (ch == 1)
            strategy = new ObjectiveEvaluation();
        else
            strategy = new DescriptiveEvaluation();

        for (Student s : students) {
            int score = strategy.evaluate(exam, s);
            System.out.println("Student: " + s.name);
            System.out.println("Score: " + score + "/" + exam.questions.size());
        }
    }
}
