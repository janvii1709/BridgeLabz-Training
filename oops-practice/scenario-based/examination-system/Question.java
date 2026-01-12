public class Question {
    String questionText;
    String correctAnswer;
    String type; // OBJECTIVE or DESCRIPTIVE

    public Question(String questionText, String correctAnswer, String type) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.type = type;
    }
}
