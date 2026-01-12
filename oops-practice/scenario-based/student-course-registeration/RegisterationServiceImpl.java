public class RegisterationServiceImpl implements RegisterationService {

    @Override
    public void enrollCourse(Student student, String course) throws CourseLimitExceededException {
        student.enroll(course);
    }

    @Override
    public void dropCourse(Student student, String course) {
        student.drop(course);
    }
}
