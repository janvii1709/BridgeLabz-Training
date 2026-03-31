import java.util.ArrayList;

public class Student extends Person {

    private ArrayList<String> courses;
    private ArrayList<String> grades;
    private final int MAX_COURSES = 3;

    public Student(int id, String name) {
        super(id, name);
        courses = new ArrayList<>();
        grades = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void enroll(String course) throws CourseLimitExceededException {
        if (courses.size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Course limit exceeded");
        }
        courses.add(course);
        grades.add("Not Assigned");
        System.out.println("Course enrolled");
    }

    public void drop(String course) {
        int index = courses.indexOf(course);
        if (index != -1) {
            courses.remove(index);
            grades.remove(index);
            System.out.println("Course dropped");
        } else {
            System.out.println("Course not found");
        }
    }

    public void addGrade(String course, String grade) {

    // grade validation
    if (!(grade.equals("A") || grade.equals("B") || grade.equals("C")
            || grade.equals("D") || grade.equals("E"))) {
        System.out.println("Invalid grade! Only A, B, C, D, E allowed");
        return;
    }

    int index = courses.indexOf(course);
    if (index != -1) {
        grades.set(index, grade);
        System.out.println("Grade added successfully");
    } else {
        System.out.println("Course not found");
    }
}


    public void viewGrades() {
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled");
            return;
        }
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i) + " : " + grades.get(i));
        }
    }
}
