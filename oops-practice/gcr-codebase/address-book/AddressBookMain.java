import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    private static Map<String, AddressBook> addressBookMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Search Person by City or State across Address Books");
            System.out.println("4. Count Contacts by City or State across Address Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addAddressBook(); break;
                case 2: selectAddressBook(); break;
                case 3: searchPersonByCityOrState(); break;
                case 4: countContactsByCityOrState(); break;
                case 5:
                    System.out.println("Exiting Program. Thank you!");
                    return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void addAddressBook() {
        System.out.print("Enter the Address Book Name: ");
        String name = sc.nextLine();
        if (addressBookMap.containsKey(name)) {
            System.out.println("The Address Book already exists!");
        } else {
            addressBookMap.put(name, new AddressBook());
            System.out.println("The Address Book '" + name + "' created successfully!");
        }
    }

    private static void selectAddressBook() {
        System.out.print("Enter the Address Book Name: ");
        String name = sc.nextLine();
        AddressBook addressBook = addressBookMap.get(name);
        if (addressBook == null) {
            System.out.println("Address Book not found!");
            return;
        }
        manageAddressBook(addressBook);
    }

    private static void manageAddressBook(AddressBook addressBook) {
        boolean running = true;

        while (running) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Sort Contacts by Name");
            System.out.println("6. Sort Contacts by City");
            System.out.println("7. Sort Contacts by State");
            System.out.println("8. Sort Contacts by ZIP");
            System.out.println("9. Back to Main Menu");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addContacts(addressBook); break;
                case 2: addressBook.displayContacts(); break;
                case 3: editContact(addressBook); break;
                case 4: deleteContact(addressBook); break;
                case 5: addressBook.sortByName(); break;
                case 6: addressBook.sortByCity(); break;
                case 7: addressBook.sortByState(); break;
                case 8: addressBook.sortByZip(); break;
                case 9: running = false; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void addContacts(AddressBook addressBook) {
        boolean adding = true;
        while (adding) {
            Contact contact = createContact();
            addressBook.addContact(contact);
            while (true) {
                System.out.print("Do you want to add another contact? (yes/no): ");
                String more = sc.nextLine().trim();
                if (more.equalsIgnoreCase("yes")) break;
                else if (more.equalsIgnoreCase("no")) { adding = false; break; }
                else System.out.println("Invalid input! Please type yes or no.");
            }
        }
    }

    private static void editContact(AddressBook addressBook) {
        System.out.print("Enter the First Name: ");
        String fn = sc.nextLine();
        System.out.print("Enter the Last Name: ");
        String ln = sc.nextLine();
        addressBook.editContact(fn, ln, sc);
    }

    private static void deleteContact(AddressBook addressBook) {
        System.out.print("Enter the First Name: ");
        String fn = sc.nextLine();
        System.out.print("Enter the Last Name: ");
        String ln = sc.nextLine();
        addressBook.deleteContact(fn, ln);
    }

    private static Contact createContact() {
        System.out.print("First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();
        System.out.print("State: ");
        String state = sc.nextLine();
        System.out.print("ZIP: ");
        String zip = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        return new Contact(firstName, lastName, address, city, state, zip, phone, email);
    }

    private static void searchPersonByCityOrState() {
        System.out.print("Enter City or State to search: ");
        String location = sc.nextLine().trim();

        List<Contact> results = new ArrayList<>();
        for (AddressBook ab : addressBookMap.values()) {
            results.addAll(ab.getContactsByCityOrState(location));
        }

        if (results.isEmpty()) System.out.println("No contacts found in " + location);
        else {
            System.out.println("Contacts found in " + location + ":");
            for (Contact c : results) System.out.println(c);
        }
    }

    private static void countContactsByCityOrState() {
        Map<String, Integer> cityCount = new HashMap<>();
        Map<String, Integer> stateCount = new HashMap<>();

        for (AddressBook ab : addressBookMap.values()) {
            for (Contact c : ab.getAllContacts()) {
                cityCount.put(c.getCity(), cityCount.getOrDefault(c.getCity(), 0) + 1);
                stateCount.put(c.getState(), stateCount.getOrDefault(c.getState(), 0) + 1);
            }
        }

        System.out.println("\nCount by City:");
        cityCount.forEach((city, count) -> System.out.println(city + ": " + count));

        System.out.println("\nCount by State:");
        stateCount.forEach((state, count) -> System.out.println(state + ": " + count));
    }
}
