import java.util.Scanner;

/*
 * EduQuiz Student Quiz Grader
 * This program compares student answers with correct answers,
 * calculates the total score, shows detailed feedback,
 * and displays percentage and pass/fail result.
 */
class EduQuiz {

    /*
     * Method: calculateScore
     * Purpose: Compare correct answers with student answers
     * using case-insensitive comparison and calculate score.
     */
    public static int calculateScore(String[] correct, String[] student) {

        int score = 0;

        // Loop through all questions
        for (int i = 0; i < correct.length; i++) {

            // Compare answers ignoring case
            if (correct[i].equalsIgnoreCase(student[i])) {
                score++; // Increase score if answer is correct
            }
        }

        return score;
    }

    /*
     * Main method
     * Program execution starts here.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Correct answers for 10-question quiz
        String[] correctAnswers = {
                "A", "C", "B", "D", "A",
                "B", "C", "D", "A", "B"
        };

        // Array to store student answers
        String[] studentAnswers = new String[10];

        System.out.println("===== EduQuiz Student Quiz =====");

        // Take student answers as input
        for (int i = 0; i < studentAnswers.length; i++) {
            System.out.print("Enter answer for Question " + (i + 1) + ": ");
            studentAnswers[i] = sc.nextLine();
        }

        System.out.println("\n----- Quiz Feedback -----");

        // Print detailed feedback for each question
        for (int i = 0; i < correctAnswers.length; i++) {

            if (correctAnswers[i].equalsIgnoreCase(studentAnswers[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect"
                        + " (Correct Answer: " + correctAnswers[i] + ")");
            }
        }

        // Calculate total score
        int score = calculateScore(correctAnswers, studentAnswers);

        // Calculate percentage
        double percentage = (score / 10.0) * 100;

        // Display final result
        System.out.println("\n----- Final Result -----");
        System.out.println("Total Score: " + score + " / 10");
        System.out.println("Percentage: " + percentage + "%");

        // Pass/Fail condition (50% passing criteria)
        if (percentage >= 50) {
            System.out.println("Result: PASS ");
        } else {
            System.out.println("Result: FAIL ");
        }
    }
}
