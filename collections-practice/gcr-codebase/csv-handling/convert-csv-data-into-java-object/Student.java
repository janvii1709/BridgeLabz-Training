public class Student {
    private int id;
    private String name;
    private int age;
    private int marks;
    // Constructor
    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    // Getters (optional if needed)
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getMarks() { return marks; }
    @Override
    public String toString() {
        return "Student[ID=" + id + ", Name=" + name + ", Age=" + age + ", Marks=" + marks + "]";
    }
}
