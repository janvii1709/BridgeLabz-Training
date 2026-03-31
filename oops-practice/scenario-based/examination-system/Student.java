import java.util.ArrayList;

public class Student {
    int id;
    String name;
    ArrayList<String> answers = new ArrayList<>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
