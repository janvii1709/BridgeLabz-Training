import java.util.*;
public class AddressBookMain {
    private static Map<String, AddressBook> addressBookMap = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add The New Address Book");
            System.out.println("2. Select The Address Book");
            System.out.println("3. Search Person by City or State across all Address Books");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: addAddressBook(sc); break;
                case 2: selectAddressBook(sc); break;
                case 3: searchAcrossAddressBooks(sc); break;
                case 4:
                    System.out.println("Exiting Program. Thank You! Have A Nice Day!");
                    sc.close();
                    return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    private static void addAddressBook(Scanner sc) {
        System.out.print("Enter The Address Book Name: ");
        String name = sc.nextLine();
        if (addressBookMap.containsKey(name)) {
            System.out.println("The Address Book already exists!");
        } else {
            addressBookMap.put(name, new AddressBook());
            System.out.println("The Address Book '" + name + "' created successfully!");
        }
    }
    private static void selectAddressBook(Scanner sc) {
        System.out.print("Enter The Address Book Name: ");
        String name = sc.nextLine();
        AddressBook addressBook = addressBookMap.get(name);
        if (addressBook == null) {
            System.out.println("The Address Book not found!");
            return;
        }
        manageAddressBook(sc, addressBook);
    }
    private static void manageAddressBook(Scanner sc, AddressBook addressBook) {
        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add The Contact");
            System.out.println("2. Display The Contacts");
            System.out.println("3. Edit The Contact");
            System.out.println("4. Delete The Contact");
            System.out.println("5. Sort Contacts by Name");
            System.out.println("6. Back");
            System.out.print("Enter choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                sc.nextLine();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: addContactsLoop(sc, addressBook); break;
                case 2: addressBook.displayContacts(); break;
                case 3:
                    System.out.print("Enter The First Name: ");
                    String fn = sc.nextLine();
                    System.out.print("Enter The Last Name: ");
                    String ln = sc.nextLine();
                    addressBook.editContact(fn, ln, sc);
                    break;
                case 4:
                    System.out.print("Enter The First Name: ");
                    String f = sc.nextLine();
                    System.out.print("Enter The Last Name: ");
                    String l = sc.nextLine();
                    addressBook.deleteContact(f, l);
                    break;
                case 5: addressBook.sortContactsByName(); break;
                case 6: running = false; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    private static void addContactsLoop(Scanner sc, AddressBook addressBook) {
        boolean adding = true;
        while (adding) {
            Contact contact = createContact(sc);
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
    private static void searchAcrossAddressBooks(Scanner sc) {
        System.out.println("Search by: 1. City  2. State");
        int opt = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name of City/State: ");
        String name = sc.nextLine();
        List<Contact> result = new ArrayList<>();
        if (opt == 1) {
            for (AddressBook ab : addressBookMap.values()) result.addAll(ab.searchByCity(name));
        } else if (opt == 2) {
            for (AddressBook ab : addressBookMap.values()) result.addAll(ab.searchByState(name));
        } else {
            System.out.println("Invalid option!");
            return;
        }
        if (result.isEmpty()) System.out.println("No contacts found in " + name);
        else {
            System.out.println("Contacts found in " + name + ":");
            for (Contact c : result) System.out.println(c);
            System.out.println("Total contacts found: " + result.size());
        }
    }
    private static Contact createContact(Scanner sc) {
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
}
