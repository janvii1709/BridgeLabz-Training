import java.util.ArrayList;
import java.util.Scanner;
// Custom exception used when phone number is not valid
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
// Contact class to store name and phone number
class Contact {
    String Name;
    String phoneNumber;
    // Constructor to initialize contact details
    Contact(String Name, String phoneNumber) {
        this.Name = Name;
        this.phoneNumber = phoneNumber;
    }
}
public class PhoneContactOrganizer {
    // ArrayList to store all contacts
    static ArrayList<Contact> Contacts = new ArrayList<>();
    // Scanner object to take user input
    static Scanner sc = new Scanner(System.in);
    // Method to add a new contact
    static void AddContact() throws InvalidPhoneNumberException {
        // Ask user for name
        System.out.print("Enter name: ");
        String Name = sc.nextLine();
        // Ask user for phone number
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        // Check if phone number is exactly 10 digits
        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(
                "Phone number must be exactly 10 digits"
            );
        }
        // Check for duplicate phone numbers
        for (Contact c : Contacts) {
            if (c.phoneNumber.equals(phoneNumber)) {
                System.out.println("Duplicate contact not allowed");
                return;
            }
        }
        // Add contact to the list
        Contacts.add(new Contact(Name, phoneNumber));
        System.out.println("Contact added successfully");
    }
    // Method to delete a contact using phone number
    static void deleteContact() {
        // Ask user for phone number to delete
        System.out.print("Enter phone number to delete: ");
        String Phone = sc.nextLine();
        // Search and remove the contact
        for (Contact c : Contacts) {
            if (c.phoneNumber.equals(Phone)) {
                Contacts.remove(c);
                System.out.println("Contact deleted");
                return;
            }
        }
        // If contact is not found
        System.out.println("Contact not found");
    }
    // Method to search a contact by name or phone number
    static void searchContact() {
        // Ask user for name or phone number
        System.out.print("Enter name or phone to search: ");
        String key = sc.nextLine();
        // Search contact in the list
        for (Contact c : Contacts) {
            if (c.Name.equalsIgnoreCase(key) || c.phoneNumber.equals(key)) {
                System.out.println(
                    "Name: " + c.Name + ", Phone: " + c.phoneNumber
                );
                return;
            }
        }
        // If no contact matches
        System.out.println("Contact not found");
    }
        public static void main(String[] args) {
        // Infinite loop to keep the program running
        while (true) {
            // Display menu options
            System.out.println("\n1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            // Read user choice
            int choice = Integer.parseInt(sc.nextLine());
            try {
                // Perform operation based on user choice
                switch (choice) {
                    case 1:
                        AddContact();
                        break;
                    case 2:
                        deleteContact();
                        break;
                    case 3:
                        searchContact();
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
            // Handle invalid phone number exception
            catch (InvalidPhoneNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
