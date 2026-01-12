public class DescriptiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(Exam exam, Student student) {
        int score = 0;

        for (int i = 0; i < exam.questions.size(); i++) {
            Question q = exam.questions.get(i);
            if (q.type.equalsIgnoreCase("DESCRIPTIVE")) {
                if (student.answers.get(i)
                        .equalsIgnoreCase(q.correctAnswer)) {
                    score++;
                }
            }
        }
        return score;
    }
}
