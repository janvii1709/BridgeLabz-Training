import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        if (contacts.contains(contact)) {
            System.out.println("Duplicate Contact found! Contact already exists.");
            return;
        }
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c);
            System.out.println("----------------------------");
        }
    }

    public void editContact(String firstName, String lastName, Scanner sc) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)
                    && contact.getLastName().equalsIgnoreCase(lastName)) {

                System.out.print("Enter new Address: ");
                contact.setAddress(sc.nextLine());
                System.out.print("Enter new City: ");
                contact.setCity(sc.nextLine());
                System.out.print("Enter new State: ");
                contact.setState(sc.nextLine());
                System.out.print("Enter new ZIP: ");
                contact.setZip(sc.nextLine());
                System.out.print("Enter new Phone: ");
                contact.setPhoneNumber(sc.nextLine());
                System.out.print("Enter new Email: ");
                contact.setEmail(sc.nextLine());

                System.out.println("Contact updated successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact(String firstName, String lastName) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().equalsIgnoreCase(firstName)
                    && contact.getLastName().equalsIgnoreCase(lastName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void sortByName() {
        contacts.sort(Comparator.comparing(Contact::getFirstName)
                .thenComparing(Contact::getLastName));
        System.out.println("Contacts sorted by Name.");
        displayContacts();
    }

    public void sortByCity() {
        contacts.sort(Comparator.comparing(Contact::getCity));
        System.out.println("Contacts sorted by City.");
        displayContacts();
    }

    public void sortByState() {
        contacts.sort(Comparator.comparing(Contact::getState));
        System.out.println("Contacts sorted by State.");
        displayContacts();
    }

    public void sortByZip() {
        contacts.sort(Comparator.comparing(Contact::getZip));
        System.out.println("Contacts sorted by ZIP.");
        displayContacts();
    }

    public List<Contact> getContactsByCityOrState(String location) {
        return contacts.stream()
                .filter(c -> c.getCity().equalsIgnoreCase(location) || c.getState().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}
