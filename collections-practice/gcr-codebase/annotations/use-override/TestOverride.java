import java.util.*;
public class TestOverride {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take user input for dog sound
        System.out.print("Enter the sound your dog makes: ");
        String sound = sc.nextLine();
        // Instantiate Dog with user input
        Animal dog = new Dog(sound);
        // Call overridden method
        dog.makeSound();
    }
}
