import java.util.ArrayList;
import java.util.List;
public class AddressBook {
    private List<Contact> contacts;
    public AddressBook() {
        contacts = new ArrayList<>();
    }
    // Adding a new contact to the address book
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("\nContact added successfully!");
    }

    // Displaying all the  contacts in the address book
    public void displayContacts() {
        System.out.println("\n--- Address Book Contacts ---");
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("----------------------------"); // used for seperating the contacts 
        }
    }
}
