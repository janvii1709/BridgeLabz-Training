import java.util.*;
public class TestObjectMapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Object> personData = new HashMap<>();
        System.out.println("Enter details for Person object:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        personData.put("name", name);
        System.out.print("Age: ");
        String age = sc.nextLine(); // keep as String, will convert in mapper
        personData.put("age", age);
        System.out.print("City: ");
        String city = sc.nextLine();
        personData.put("city", city);
        // Create Person object dynamically
        Person person = ObjectMapper.toObject(Person.class, personData);
        System.out.println("\nMapped Person Object: " + person);
    }
}
