import java.util.*;
public class AddressBookMain {
    private static Map<String, AddressBook> addressBookMap = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Search Person Across Address Books by City/State");
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
                case 1:
                    addAddressBook(sc);
                    break;
                case 2:
                    selectAddressBook(sc);
                    break;
                case 3:
                    searchAcrossAddressBooks(sc);
                    break;
                case 4:
                    System.out.println("Exiting Program. Thank You! Have A Nice Day!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addAddressBook(Scanner sc) {
        System.out.print("Enter Address Book Name: ");
        String name = sc.nextLine();
        if (addressBookMap.containsKey(name)) {
            System.out.println("The Address Book already exists!");
        } else {
            addressBookMap.put(name, new AddressBook());
            System.out.println("The Address Book '" + name + "' created successfully!");
        }
    }

    private static void selectAddressBook(Scanner sc) {
        System.out.print("Enter Address Book Name: ");
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
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    boolean adding = true;
                    while (adding) {
                        Contact contact = createContact(sc);
                        addressBook.addContact(contact);

                        while (true) {
                            System.out.print("Do you want to add another contact? (yes/no): ");
                            String more = sc.nextLine().trim();
                            if (more.equalsIgnoreCase("yes")) break;
                            else if (more.equalsIgnoreCase("no")) {
                                adding = false;
                                break;
                            } else {
                                System.out.println("Invalid input! Please type yes or no.");
                            }
                        }
                    }
                    break;
                case 2:
                    addressBook.displayContacts();
                    break;
                case 3:
                    System.out.print("Enter First Name: ");
                    String fn = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    String ln = sc.nextLine();
                    addressBook.editContact(fn, ln, sc);
                    break;
                case 4:
                    System.out.print("Enter First Name: ");
                    String f = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    String l = sc.nextLine();
                    addressBook.deleteContact(f, l);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
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

    private static void searchAcrossAddressBooks(Scanner sc) {
        System.out.println("Search by: 1. City  2. State");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter City/State Name: ");
        String name = sc.nextLine();

        int totalCount = 0;

        for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
            List<Contact> results = (choice == 1)
                    ? entry.getValue().getPersonsByCity(name)
                    : entry.getValue().getPersonsByState(name);

            if (!results.isEmpty()) {
                System.out.println("\nAddress Book: " + entry.getKey());
                results.forEach(System.out::println);
                totalCount += results.size();
            }
        }

        if (totalCount == 0) System.out.println("No contacts found!");
        else if (choice == 1)
            System.out.println("Total Contacts in City '" + name + "' : " + totalCount);
        else
            System.out.println("Total Contacts in State '" + name + "' : " + totalCount);
    }
}
