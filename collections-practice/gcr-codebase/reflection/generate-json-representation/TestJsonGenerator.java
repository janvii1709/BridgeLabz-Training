import java.util.*;
public class TestJsonGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person person = new Person();
        try {
            Class<?> cls = person.getClass();
            // Iterate fields and take user input dynamically
            for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                System.out.print("Enter value for " + field.getName() + " (" + field.getType().getSimpleName() + "): ");
                String input = sc.nextLine();
                if (field.getType() == int.class) {
                    field.set(person, Integer.parseInt(input));
                } else if (field.getType() == String.class) {
                    field.set(person, input);
                }
            }
            // Generate JSON
            String json = JsonGenerator.toJson(person);
            System.out.println("\nJSON Representation:");
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
