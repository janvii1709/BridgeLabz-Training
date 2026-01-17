import java.util.*;
public class AddressBook {
    private List<Contact> contacts;
    public AddressBook() {
        contacts = new ArrayList<>();
    }
    // Adding the  new contact to the address book
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("\nContacts are added successfully!");
    }

    // Displaying all the contacts of the address book
    public void displayContacts() {
        System.out.println("\n--- Address Book Contact Deatils ---");
        if (contacts.isEmpty()) {
            System.out.println("No contacts are available.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("----------------------------");
        }
    }
    // Editing the existing contact by name in the address book
    public void editContact(String firstName, String lastName, Scanner sc) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) &&
                contact.getLastName().equalsIgnoreCase(lastName)) {
                found = true;
                System.out.println("\nEditing the Contact: " + firstName + " " + lastName);
                System.out.println("Enter the new Address (current: " + contact.getAddress() + "):");
                contact.setAddress(sc.nextLine());
                System.out.println("Enter the new City (current: " + contact.getCity() + "):");
                contact.setCity(sc.nextLine());
                System.out.println("Enter the new State (current: " + contact.getState() + "):");
                contact.setState(sc.nextLine());
                System.out.println("Enter the new ZIP (current: " + contact.getZip() + "):");
                contact.setZip(sc.nextLine());
                System.out.println("Enter the new Phone Number (current: " + contact.getPhoneNumber() + "):");
                contact.setPhoneNumber(sc.nextLine());
                System.out.println("Enter the new Email (current: " + contact.getEmail() + "):");
                contact.setEmail(sc.nextLine());
                System.out.println("\nContact are now updated successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Contact is not found with name: " + firstName + " " + lastName);
        }
    }

    // Deleting a contact by name in the address book
    public void deleteContact(String firstName, String lastName) {
        Iterator<Contact> iterator = contacts.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().equalsIgnoreCase(firstName) &&
                contact.getLastName().equalsIgnoreCase(lastName)) {
                iterator.remove();
                System.out.println("\nContact is deleted successfully: " + firstName + " " + lastName);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact is not found with name: " + firstName + " " + lastName);
        }
    }
}
