public class Person {
    private String name;
    private int age;
    private String city;
    // Default constructor
    public Person() {}
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", city='" + city + "'}";
    }
}
