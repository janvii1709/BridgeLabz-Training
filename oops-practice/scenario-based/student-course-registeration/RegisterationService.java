public interface RegisterationService {
    void enrollCourse(Student student, String course) throws CourseLimitExceededException;
    void dropCourse(Student student, String course);
}
