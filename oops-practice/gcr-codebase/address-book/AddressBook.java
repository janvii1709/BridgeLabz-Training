import java.util.ArrayList;
import java.util.List;
public class AddressBook {
    private List<Contact> contacts;
    public AddressBook() {
        contacts = new ArrayList<>();
    }
    //Adding the contact to the address book
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added: " + contact.getFirstName() + " " + contact.getLastName());
    }

    // Displaying all the contacts in the address book
    public void displayContacts() {
        System.out.println("\n--- Address Book Details ---");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
