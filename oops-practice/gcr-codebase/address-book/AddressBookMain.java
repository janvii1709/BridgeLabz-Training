import java.util.Scanner;
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add New Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            // Check if input is an integer or not 
            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice! Please enter a number.");
                sc.nextLine(); // consume invalid input
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine(); //We are using this for Consuming the newline character 
            switch (choice) {
                case 1:
                    Contact contact = createContact(sc);
                    addressBook.addContact(contact);
                    break;
                case 2:
                    addressBook.displayContacts();
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting Address Book. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }
    }
    // Method to take input and create a new contact
    private static Contact createContact(Scanner sc) {
        System.out.println("Enter The First Name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter The Last Name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter The Address: ");
        String address = sc.nextLine();
        System.out.println("Enter The City: ");
        String city = sc.nextLine();
        System.out.println("Enter The State: ");
        String state = sc.nextLine();
        System.out.println("Enter The ZIP: ");
        String zip = sc.nextLine();
        System.out.println("Enter The Phone Number: ");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter The Email: ");
        String email = sc.nextLine();
        return new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
    }
}
