import java.util.*;
public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();
    private Map<String, List<Contact>> cityDictionary = new HashMap<>();
    private Map<String, List<Contact>> stateDictionary = new HashMap<>();
    public void addContact(Contact contact) {
        if (contacts.contains(contact)) {
            System.out.println("Duplicate Contact found! Contact already exists.");
            return;
        }
        contacts.add(contact);
        cityDictionary.computeIfAbsent(contact.getCity().toLowerCase(), k -> new ArrayList<>()).add(contact);
        stateDictionary.computeIfAbsent(contact.getState().toLowerCase(), k -> new ArrayList<>()).add(contact);
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
                cityDictionary.get(contact.getCity().toLowerCase()).remove(contact);
                stateDictionary.get(contact.getState().toLowerCase()).remove(contact);
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
                cityDictionary.computeIfAbsent(contact.getCity().toLowerCase(), k -> new ArrayList<>()).add(contact);
                stateDictionary.computeIfAbsent(contact.getState().toLowerCase(), k -> new ArrayList<>()).add(contact);
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
                cityDictionary.get(contact.getCity().toLowerCase()).remove(contact);
                stateDictionary.get(contact.getState().toLowerCase()).remove(contact);

                System.out.println("The Contact is deleted successfully!");
                return;
            }
        }
        System.out.println("The Contact is not found.");
    }
    public List<Contact> searchByCity(String city) {
        return cityDictionary.getOrDefault(city.toLowerCase(), new ArrayList<>());
    }
    public List<Contact> searchByState(String state) {
        return stateDictionary.getOrDefault(state.toLowerCase(), new ArrayList<>());
    }
    public void countByCity(String city) {
        System.out.println("Number of contacts in " + city + ": " + searchByCity(city).size());
    }
    public void countByState(String state) {
        System.out.println("Number of contacts in " + state + ": " + searchByState(state).size());
    }
    public void sortContactsByName() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to sort.");
            return;
        }
        contacts.sort(Comparator.comparing(c -> (c.getFirstName() + " " + c.getLastName()).toLowerCase()));
        System.out.println("Contacts sorted alphabetically by name:");
        displayContacts();
    }
}
