import java.util.*;
// Custom Exception
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}
// Quiz Processor Class
class QuizProcessor {
    // Method to calculate score
    public static int CalculateScore(String[] CorrectAns, String[] UserAns)
            throws InvalidQuizSubmissionException {
        if (CorrectAns.length != UserAns.length) {
            throw new InvalidQuizSubmissionException("Number of answers does not match!");
        }
        int Score = 0;
        for (int i = 0; i < CorrectAns.length; i++) {
            if (UserAns[i].equalsIgnoreCase(CorrectAns[i])) {
                Score++;
            }
        }
        return Score;
    }
    // Method to return grade
    public static String GetGrade(int Score, int Total) {
        double Percentage = (Score * 100.0) / Total;
        if (Percentage >= 80) return "A";
        else if (Percentage >= 60) return "B";
        else if (Percentage >= 40) return "C";
        else return "Fail";
    }
}
// Main Class
public class OnlineQuizPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Stored correct answers (System / Teacher)
        String[] CorrectAns = {"A", "B", "C", "D", "A"};
        int TotalQuestions = CorrectAns.length;
        // Store scores of multiple users
        List<Integer> ScoreList = new ArrayList<>();
        System.out.print("Enter number of users: ");
        int Users = sc.nextInt();
        sc.nextLine(); // clear buffer
        for (int u = 1; u <= Users; u++) {
            try {
                System.out.println("\nEnter answers for User " + u + ":");
                String[] UserAns = new String[TotalQuestions];
                // Taking user answers
                for (int i = 0; i < TotalQuestions; i++) {
                    System.out.print("Q" + (i + 1) + ": ");
                    UserAns[i] = sc.nextLine();
                }
                // Calculate score
                int Score = QuizProcessor.CalculateScore(CorrectAns, UserAns);
                ScoreList.add(Score);
                // Get grade
                String Grade = QuizProcessor.GetGrade(Score, TotalQuestions);
                System.out.println("Score: " + Score + "/" + TotalQuestions);
                System.out.println("Grade: " + Grade);
            } catch (InvalidQuizSubmissionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("\nAll Users Scores: " + ScoreList);
    }
}
