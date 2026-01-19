import java.util.*;
public class AddressBookMain {
    private static Map<String, AddressBook> addressBookMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book Program");
        while (true) {
            System.out.println("\n1. Add Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Search Person by City/State (All Address Books)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addAddressBook(sc);
                case 2 -> selectAddressBook(sc);
                case 3 -> searchAcrossAddressBooks(sc);
                case 4 -> {
                    System.out.println("Thank You!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
    private static void addAddressBook(Scanner sc) {
        System.out.print("Enter Address Book Name: ");
        String name = sc.nextLine();
        if (addressBookMap.containsKey(name)) {
            System.out.println("Address Book already exists!");
        } else {
            addressBookMap.put(name, new AddressBook());
            System.out.println("Address Book created!");
        }
    }
    private static void selectAddressBook(Scanner sc) {
        System.out.print("Enter Address Book Name: ");
        String name = sc.nextLine();
        AddressBook book = addressBookMap.get(name);
        if (book == null) {
            System.out.println("Not found!");
            return;
        }
        boolean run = true;
        while (run) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1 -> book.addContact(createContact(sc));
                case 2 -> book.displayContacts();
                case 3 -> {
                    System.out.print("First Name: ");
                    String fn = sc.nextLine();
                    System.out.print("Last Name: ");
                    String ln = sc.nextLine();
                    book.editContact(fn, ln, sc);
                }
                case 4 -> {
                    System.out.print("First Name: ");
                    String fn = sc.nextLine();
                    System.out.print("Last Name: ");
                    String ln = sc.nextLine();
                    book.deleteContact(fn, ln);
                }
                case 5 -> run = false;
                default -> System.out.println("Invalid!");
            }
        }
    }

    private static Contact createContact(Scanner sc) {
        System.out.print("First Name: ");
        String fn = sc.nextLine();
        System.out.print("Last Name: ");
        String ln = sc.nextLine();
        System.out.print("Address: ");
        String ad = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();
        System.out.print("State: ");
        String state = sc.nextLine();
        System.out.print("Zip: ");
        String zip = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        return new Contact(fn, ln, ad, city, state, zip, phone, email);
    }

    // SEARCHING IT ACROSS MULTIPLE ADDRESS BOOKS
    private static void searchAcrossAddressBooks(Scanner sc) {
        System.out.println("Search by: 1. City  2. State");
        int ch = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
            List<Contact> results = (ch == 1)? entry.getValue().getPersonsByCity(name): entry.getValue().getPersonsByState(name);
            if (!results.isEmpty()) {
                found = true;
                System.out.println("\nAddress Book: " + entry.getKey());
                results.forEach(System.out::println);
            }
        }
        if (!found) {
            System.out.println("No persons found!");
        }
    }
}
