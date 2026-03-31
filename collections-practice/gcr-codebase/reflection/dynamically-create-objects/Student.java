public class Student {
    String name;
    int age;
    // Default constructor
    public Student() {
        this.name = "Unknown";
        this.age = 0;
    }
    // Parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}
