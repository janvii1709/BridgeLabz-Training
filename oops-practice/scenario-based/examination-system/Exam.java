import java.util.ArrayList;

public class Exam {
    String examName;
    ArrayList<Question> questions = new ArrayList<>();

    public Exam(String examName) {
        this.examName = examName;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }
}
