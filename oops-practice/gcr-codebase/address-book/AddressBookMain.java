import java.util.*;
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add The New Contact");
            System.out.println("2. Display All The Contacts");
            System.out.println("3. Edit The Contact");
            System.out.println("4. Delete The Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice! Please enter a number.");
                sc.nextLine(); // Used for consuming invalid input
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine(); // Used for consuming the newline chracter after the nextInt()
            switch (choice) {
                case 1:
                    boolean adding = true;
                    while (adding) {
                        Contact contact = createContact(sc);
                        addressBook.addContact(contact);
                        while (true) { // Loop until valid response
                        System.out.print("Do you want to add another contact? (yes/no): ");
                        String more = sc.nextLine().trim();
                        if (more.equalsIgnoreCase("yes")) {
                            break; // continue adding
                            } else if (more.equalsIgnoreCase("no")) {
                                adding = false; // stop adding
                                break;
                            } else {
                                System.out.println("Invalid input! Please enter 'yes' or 'no'.");
                            }
                        }
                    }
                    break;
                case 2:
                    addressBook.displayContacts();
                    break;
                case 3:
                    System.out.print("Enter The First Name of contact to edit: ");
                    String firstNameEdit = sc.nextLine();
                    System.out.print("Enter The Last Name of contact to edit: ");
                    String lastNameEdit = sc.nextLine();
                    addressBook.editContact(firstNameEdit, lastNameEdit, sc);
                    break;

                case 4:
                    System.out.print("Enter The First Name of contact to delete: ");
                    String firstNameDel = sc.nextLine();
                    System.out.print("Enter The Last Name of contact to delete: ");
                    String lastNameDel = sc.nextLine();
                    addressBook.deleteContact(firstNameDel, lastNameDel);
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting The Address Book.ThankYou ! Have A Nice Day ! ");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1, 2, 3, 4, or 5.");
            }
        }
    }

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
