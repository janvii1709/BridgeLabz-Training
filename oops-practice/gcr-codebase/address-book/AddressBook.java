import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AddressBook {
    private List<Contact> contacts;
    public AddressBook() {
        contacts = new ArrayList<>();
    }
    // Adding the new contact to the address book
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("\nContact added successfully!");
    }
    // Displaying all the  contacts of the address book
    public void displayContacts() {
        System.out.println("\n--- Address Book Contact Details ---");
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("----------------------------"); //Used for seperating the contacts 
        }
    }
    // Editing the existing contact by first and last name
    public void editContact(String firstName, String lastName, Scanner sc) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) &&
                contact.getLastName().equalsIgnoreCase(lastName)) {
                found = true;
                System.out.println("\nEditing The Contact: " + firstName + " " + lastName);
                System.out.println("Enter The new Address (current: " + contact.getAddress() + "):");
                contact.setAddress(sc.nextLine());
                System.out.println("Enter The new City (current: " + contact.getCity() + "):");
                contact.setCity(sc.nextLine());
                System.out.println("Enter The new State (current: " + contact.getState() + "):");
                contact.setState(sc.nextLine());
                System.out.println("Enter The new ZIP (current: " + contact.getZip() + "):");
                contact.setZip(sc.nextLine());
                System.out.println("Enter The new Phone Number (current: " + contact.getPhoneNumber() + "):");
                contact.setPhoneNumber(sc.nextLine());
                System.out.println("Enter The new Email (current: " + contact.getEmail() + "):");
                contact.setEmail(sc.nextLine());
                System.out.println("\nThe Contact is updated successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("The Contact is not found with name: " + firstName + " " + lastName);
        }
    }
}
