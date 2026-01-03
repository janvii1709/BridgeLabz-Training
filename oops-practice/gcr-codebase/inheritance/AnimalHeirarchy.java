import java.util.*;

// Creating a super class with attributes
class Animal {
    String name;
    int age;
    
    // Creating a constructor of the super class
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Creating a method
    void makeSound() {
        System.out.println("Animals makes some sound");
    }
}
 
// Creating a subclass named Dog 
class Dog extends Animal {
    // Creating a constructor using super keyword
    Dog(String name, int age) {
        super(name, age);
    }
    
    // Creating a method
    void makeSound() {
        System.out.println(name + " barks");
    }
}

// Creating a subclass named cat
class Cat extends Animal {
    // Creating a constructor using super keyword
    Cat(String name, int age) {
        super(name, age);
    }
    
    // Creating a method 
    void makeSound() {
        System.out.println(name + " meows");
    }
}

// Creating a subclass named bird
class Bird extends Animal {
    // Creating a constructor using super keyword
    Bird(String name, int age) {
        super(name, age);
    }
    
    // Creating a method
    void makeSound() {
        System.out.println(name + " chirps");
    }
}

public class AnimalHeirarchy {

    public static void main(String[] args) {
        // Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        // Input for Dog with validation
        String dogName;
        while (true) {
            System.out.print("Enter the name of the dog : ");
            dogName = sc.next();
            if (dogName.matches("[a-zA-Z]+")) { // Check if name contains only letters
                break;
            } else {
                System.out.println("Invalid input! Name must contain only letters.");
            }
        }

        int dogAge;
        while (true) {
            System.out.print("Enter the age of the dog : ");
            if (sc.hasNextInt()) { // Check if input is an integer
                dogAge = sc.nextInt();
                break;
            } else {
                System.out.println("Invalid input! Age must be an integer.");
                sc.next(); // consume the invalid input
            }
        }

        Animal dog = new Dog(dogName, dogAge);
        dog.makeSound();
        
        System.out.println();
        
        // Input for Cat with validation
        String catName;
        while (true) {
            System.out.print("Enter the name of the cat : ");
            catName = sc.next();
            if (catName.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("Invalid input! Name must contain only letters.");
            }
        }

        int catAge;
        while (true) {
            System.out.print("Enter the age of the cat : ");
            if (sc.hasNextInt()) {
                catAge = sc.nextInt();
                break;
            } else {
                System.out.println("Invalid input! Age must be an integer.");
                sc.next();
            }
        }

        Animal cat = new Cat(catName, catAge);
        cat.makeSound();
        
        System.out.println();
        
        // Input for Bird with validation
        String birdName;
        while (true) {
            System.out.print("Enter the name of the bird : ");
            birdName = sc.next();
            if (birdName.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("Invalid input! Name must contain only letters.");
            }
        }

        int birdAge;
        while (true) {
            System.out.print("Enter the age of the bird : ");
            if (sc.hasNextInt()) {
                birdAge = sc.nextInt();
                break;
            } else {
                System.out.println("Invalid input! Age must be an integer.");
                sc.next();
            }
        }

        Animal bird = new Bird(birdName, birdAge);
        bird.makeSound();
    }
}
