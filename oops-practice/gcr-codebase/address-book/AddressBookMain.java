// AddressBookMain.java
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);

        // Creating a contact by taking the user input
        System.out.print("\nEnter The First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter The Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter The Address: ");
        String address = sc.nextLine();

        System.out.print("Enter The City: ");
        String city = sc.nextLine();

        System.out.print("Enter The State: ");
        String state = sc.nextLine();

        System.out.print("Enter The ZIP: ");
        String zip = sc.nextLine();

        System.out.print("Enter The Phone Number: ");
        String phoneNumber = sc.nextLine();

        System.out.print("Enter The Email: ");
        String email = sc.nextLine();

        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        addressBook.addContact(contact);
        addressBook.displayContacts();
    }
}
