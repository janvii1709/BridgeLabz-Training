import java.util.Scanner;
// Superclass
class Person {
    String name;
    int id;
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}
// Interface
interface Worker {
    void performDuties();
}
// Chef subclass
class Chef extends Person implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }
    public void performDuties() {
        System.out.println("Chef is preparing food.");
    }
}
// Waiter subclass
class Waiter extends Person implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }
    public void performDuties() {
        System.out.println("Waiter is serving food to customers.");
    }
}
// Main class
public class ResturantManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input for Chef
        System.out.println("Enter Chef details:");
        System.out.print("Name: ");
        String chefName = sc.nextLine();
        System.out.print("ID: ");
        int chefId = sc.nextInt();
        sc.nextLine(); // consume newline
        Chef chef = new Chef(chefName, chefId);
        // Input for Waiter
        System.out.println("\nEnter Waiter details:");
        System.out.print("Name: ");
        String waiterName = sc.nextLine();
        System.out.print("ID: ");
        int waiterId = sc.nextInt();
        Waiter waiter = new Waiter(waiterName, waiterId);
        // Output
        System.out.println("\nChef Details:");
        chef.displayInfo();
        chef.performDuties();
        System.out.println("\nWaiter Details:");
        waiter.displayInfo();
        waiter.performDuties();
    }
}
