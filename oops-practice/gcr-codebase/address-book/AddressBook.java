import java.util.*;
public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();
    public void addContact(Contact contact) {
        if (contacts.contains(contact)) {
            System.out.println("Duplicate Contact found! Contact already exists.");
            return;
        }
        contacts.add(contact);
        System.out.println("The Contact added successfully!");
    }
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contact is found.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("----------------------------");
        }
    }
    public void editContact(String firstName, String lastName, Scanner sc) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)&& contact.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Enter the new Address:");
                contact.setAddress(sc.nextLine());
                System.out.println("Enter the new City:");
                contact.setCity(sc.nextLine());
                System.out.println("Enter the new State:");
                contact.setState(sc.nextLine());
                System.out.println("Enter the new ZIP:");
                contact.setZip(sc.nextLine());
                System.out.println("Enter the new Phone:");
                contact.setPhoneNumber(sc.nextLine());
                System.out.println("Enter the new Email:");
                contact.setEmail(sc.nextLine());
                System.out.println("The Contact is updated successfully!");
                return;
            }
        }
        System.out.println("The Contact is not found.");
    }
    public void deleteContact(String firstName, String lastName) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().equalsIgnoreCase(firstName)&& contact.getLastName().equalsIgnoreCase(lastName)) {
                iterator.remove();
                System.out.println("The Contact is deleted successfully!");
                return;
            }
        }
        System.out.println("The Contact is not found.");
    }
}
