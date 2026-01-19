import java.util.*;
public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();
    private Map<String, List<Contact>> cityMap = new HashMap<>();
    private Map<String, List<Contact>> stateMap = new HashMap<>();
    public void addContact(Contact contact) {
        if (contacts.contains(contact)) {
            System.out.println("Duplicate Contact! Already exists.");
            return;
        }
        contacts.add(contact);
        cityMap.computeIfAbsent(contact.getCity(), k -> new ArrayList<>()).add(contact);
        stateMap.computeIfAbsent(contact.getState(), k -> new ArrayList<>()).add(contact);
        System.out.println("Contact added successfully!");
    }
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        contacts.forEach(System.out::println);
    }
    public void editContact(String fn, String ln, Scanner sc) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(fn) &&
                c.getLastName().equalsIgnoreCase(ln)) {
                System.out.print("New Address: ");
                c.setAddress(sc.nextLine());
                System.out.print("New City: ");
                c.setCity(sc.nextLine());
                System.out.print("New State: ");
                c.setState(sc.nextLine());
                System.out.print("New Zip: ");
                c.setZip(sc.nextLine());
                System.out.print("New Phone: ");
                c.setPhoneNumber(sc.nextLine());
                System.out.print("New Email: ");
                c.setEmail(sc.nextLine());
                System.out.println("Contact updated!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }
    public void deleteContact(String fn, String ln) {
        Iterator<Contact> it = contacts.iterator();
        while (it.hasNext()) {
            Contact c = it.next();
            if (c.getFirstName().equalsIgnoreCase(fn) &&
                c.getLastName().equalsIgnoreCase(ln)) {
                it.remove();
                cityMap.get(c.getCity()).remove(c);
                stateMap.get(c.getState()).remove(c);
                System.out.println("Contact deleted!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }
    public List<Contact> getContacts() {
        return contacts;
    }
    public List<Contact> getPersonsByCity(String city) {
        return cityMap.getOrDefault(city, new ArrayList<>());
    }
    public List<Contact> getPersonsByState(String state) {
        return stateMap.getOrDefault(state, new ArrayList<>());
    }
}
