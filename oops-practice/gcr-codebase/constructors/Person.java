
// Creating a class named person with attributes
class Person {
    String name;
    int age;

    // Creating a Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Creating a Copy constructor
    Person(Person person) {
        this.name = person.name;
        this.age = person.age;
    }

    // Method for displaying copied content method
    void displayDetails() {
        System.out.println("Name of the person is: " + name);
        System.out.println("Age of the person is: " + age);
   
    }
     
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
    	// Making an object of the class person to call it by name
		Person person1 = new Person("Janhavi", 22);
		System.out.println("Details of person1 are");
		person1.displayDetails(); // Calling the method to display details

		System.out.println(); // For extra space
		
        // Creating copy of person1
        Person person2 = new Person(person1);
        System.out.println("Copied details of person1 in person2 are");
        person2.displayDetails(); // Calling the method to display details

	}
}