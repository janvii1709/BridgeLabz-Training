import java.util.*;

public class ExamProctor {

    static Scanner sc = new Scanner(System.in);

    // Stack for navigation
    static Stack<Integer> navigationStack = new Stack<>();

    // Map for student answers
    static HashMap<Integer, String> studentAnswers = new HashMap<>();

    // Correct answers (predefined)
    static HashMap<Integer, String> correctAnswers = new HashMap<>();

    // Initialize correct answers
    static void loadCorrectAnswers() {
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");
        correctAnswers.put(4, "D");
        correctAnswers.put(5, "A");
    }

    // Visit a question
    static void visitQuestion() {
        System.out.print("Enter Question ID: ");
        int qid = sc.nextInt();
        sc.nextLine();

        navigationStack.push(qid);
        System.out.println("Visited Question: " + qid);
    }

    // Answer a question
    static void answerQuestion() {
        System.out.print("Enter Question ID: ");
        int qid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter your Answer: ");
        String ans = sc.nextLine().toUpperCase();

        studentAnswers.put(qid, ans);
        System.out.println("Answer saved!");
    }

    // Go to previous question
    static void goBack() {
        if (navigationStack.isEmpty()) {
            System.out.println("No previous question!");
            return;
        }
        navigationStack.pop();
        if (!navigationStack.isEmpty()) {
            System.out.println("Back to Question: " + navigationStack.peek());
        } else {
            System.out.println("No question left in history!");
        }
    }

    // Evaluate score
    static void submitExam() {
        int score = 0;

        for (int qid : correctAnswers.keySet()) {
            if (studentAnswers.containsKey(qid)) {
                if (studentAnswers.get(qid).equals(correctAnswers.get(qid))) {
                    score++;
                }
            }
        }

        System.out.println("📊 Exam Submitted!");
        System.out.println("Total Questions: " + correctAnswers.size());
        System.out.println("Correct Answers: " + score);
        System.out.println("Final Score: " + score + "/" + correctAnswers.size());
    }

    public static void main(String[] args) {

        loadCorrectAnswers();

        while (true) {
            System.out.println("\n ExamProctor Menu");
            System.out.println("1. Visit Question");
            System.out.println("2. Answer Question");
            System.out.println("3. Go Back");
            System.out.println("4. Submit Exam");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    visitQuestion();
                    break;
                case 2:
                    answerQuestion();
                    break;
                case 3:
                    goBack();
                    break;
                case 4:
                    submitExam();
                    return;
                case 5:
                    System.out.println(" Exiting ExamProctor");
                    return;
                default:
                    System.out.println(" Invalid choice!");
            }
        }
    }
}
