import java.util.ArrayList;
import java.util.List;

public class Course<T extends CourseType> {
    private List<T> courses;

    public Course() {
        courses = new ArrayList<>();
    }

    // Add a course
    public void addCourse(T course) {
        courses.add(course);
        System.out.println(course.getCourseName() + " added successfully.");
    }

    // Display all courses
    public void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (T course : courses) {
            course.displayInfo();
        }
    }

    // Display any type of course using wildcard
    public static void displayAnyCourse(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.displayInfo();
        }
    }

    public List<T> getCourses() {
        return courses;
    }
}
