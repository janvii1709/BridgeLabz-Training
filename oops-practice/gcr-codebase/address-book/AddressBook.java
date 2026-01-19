import java.util.*;
public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();
    private Map<String, List<Contact>> cityMap = new HashMap<>();
    private Map<String, List<Contact>> stateMap = new HashMap<>();
    public void addContact(Contact contact) {
        if (contacts.contains(contact)) {
            System.out.println("Duplicate Contact found! Contact already exists.");
            return;
        }
        contacts.add(contact);
        cityMap.putIfAbsent(contact.getCity(), new ArrayList<>());
        cityMap.get(contact.getCity()).add(contact);
        stateMap.putIfAbsent(contact.getState(), new ArrayList<>());
        stateMap.get(contact.getState()).add(contact);

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
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                cityMap.get(contact.getCity()).remove(contact);
                stateMap.get(contact.getState()).remove(contact);

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
                cityMap.putIfAbsent(contact.getCity(), new ArrayList<>());
                cityMap.get(contact.getCity()).add(contact);
                stateMap.putIfAbsent(contact.getState(), new ArrayList<>());
                stateMap.get(contact.getState()).add(contact);

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
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                iterator.remove();
                cityMap.get(contact.getCity()).remove(contact);
                stateMap.get(contact.getState()).remove(contact);
                System.out.println("The Contact is deleted successfully!");
                return;
            }
        }
        System.out.println("The Contact is not found.");
    }

    public List<Contact> getPersonsByCity(String city) {
        return cityMap.getOrDefault(city, new ArrayList<>());
    }

    public List<Contact> getPersonsByState(String state) {
        return stateMap.getOrDefault(state, new ArrayList<>());
    }
}
