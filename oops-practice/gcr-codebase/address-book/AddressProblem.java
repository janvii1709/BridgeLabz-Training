import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddressProblem {

	static Scanner sc = new Scanner(System.in);
	static ExecutorService executor = Executors.newFixedThreadPool(3);
	static Map<String, Contacts> addressBooks = new HashMap<>();

	// UC-9: Maintain dictionaries for City → Persons and State → Persons
	static Map<String, List<CreateContact>> cityDictionary = new HashMap<>();
	static Map<String, List<CreateContact>> stateDictionary = new HashMap<>();

	public static void main(String[] args) {
		
		System.out.println("Welcome to Address Book Program");
		
		// UC-5 and UC-6: Adding multiple Contacts and Address Books
		while(true) {
			System.out.println("\n1. Add Address Book");
			System.out.println("2. Add Contact");
			System.out.println("3. Display Contact");
			System.out.println("4. Edit Contact");
			System.out.println("5. Delete Contact");
			System.out.println("6. Search Contact by City or State");
			System.out.println("7. View Persons by City"); 
			System.out.println("8. View Persons by State");  
			System.out.println("9. Count Persons by City");
			System.out.println("10. Count Persons by State");  
			System.out.println("11. Sort Contacts by Name");
			System.out.println("12. Sort Contacts by City");
			System.out.println("13. Sort Contacts by State");
			System.out.println("14. Sort Contacts by Zip");   
			System.out.println("15. Save Address Book to File");
			System.out.println("16. Load Address Book from File");
			System.out.println("17. Save Address Book to CSV");
			System.out.println("18. Load Address Book from CSV");
			System.out.println("19. Save Address Book to JSON");
			System.out.println("20. Load Address Book from JSON");
			System.out.println("21. Send Contact to JSON Server");
			System.out.println("22. Fetch Contacts from JSON Server");
			System.out.println("23. Exit");
			
			System.out.print("\nEnter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch(choice) {
				// UC-6: Add a new Address Book
				case 1 :
					System.out.print("Enter Address Book Name: ");
                    String bookName = sc.nextLine();

                    if(addressBooks.containsKey(bookName)) {
                        System.out.println("Address Book already exists");
                    } else {
                        addressBooks.put(bookName, new Contacts());
                        System.out.println("Address Book created successfully");
                    }
                    break;

				// UC-1 & UC-4: Add a Contact to a selected Address Book
				case 2 : 
					Contacts contact = getAddressBook();
                    if(contact == null) break;

					System.out.print("Enter the first name: ");
					String firstName = sc.nextLine();
					
					System.out.print("Enter the last name: ");
					String lastName = sc.nextLine();
					
					System.out.print("Enter the address: ");
					String address = sc.nextLine();
					
					System.out.print("Enter the city: ");
					String city = sc.nextLine();
					
					System.out.print("Enter the state: ");
					String state = sc.nextLine();
					
					System.out.print("Enter the zip code: ");
					int zip = sc.nextInt();
					
					System.out.print("Enter the phone number: ");
					long phoneNumber = sc.nextLong();
					sc.nextLine();
					
					System.out.print("Enter the email: ");
					String email = sc.nextLine();
					
					CreateContact contacts = new CreateContact(firstName, lastName, address, city, state, zip, phoneNumber, email);
					
					contact.addContact(contacts);
					break;
					
				// UC-2 / UC-4: Display all contacts in selected Address Book
				case 3 :
					contact = getAddressBook();
                    if(contact != null) {
                        contact.displayContact();
                    }
                    break;
				
				// UC-3: Edit existing contact in selected Address Book
				case 4 :
					contact = getAddressBook();
                    if (contact == null) break;

					System.out.print("Enter the first name: ");
					String searchFirstName = sc.nextLine();
					
					System.out.print("Enter the last name: ");
					String searchLastName = sc.nextLine();
					
					contact.editContact(searchFirstName, searchLastName, sc);
					break;
					
				// UC-4: Delete existing contact in selected Address Book
				case 5 :
					contact = getAddressBook();
                    if (contact == null) break;

					System.out.print("Enter the fisrt name: ");
					searchFirstName = sc.nextLine();
					
					System.out.print("Enter the last name: ");
					searchLastName = sc.nextLine();
					
					contact.deleteContact(searchFirstName, searchLastName);
					break;
				
				// UC-8: Search by City/State across multiple Address Books
                case 6:
                    System.out.print("Search by City or State (C/S): ");
                    String csChoice = sc.nextLine();

                    if(csChoice.equalsIgnoreCase("C")) {
                        System.out.print("Enter City Name: ");
                        String cityName = sc.nextLine();
                        searchByCity(cityName);
                    } else if(csChoice.equalsIgnoreCase("S")) {
                        System.out.print("Enter State Name: ");
                        String stateName = sc.nextLine();
                        searchByState(stateName);
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;

				// UC-9: View Persons by City
				case 7:
					viewPersonsByCity();
					break;
				
				// UC-9: View Persons by State
				case 8:
					viewPersonsByState();
					break;

				// UC-10: Count Persons by City
				case 9:
					countByCity();
					break;

				// UC-10: Count Persons by State
				case 10:
					countByState();
					break;

				case 11:
					contact = getAddressBook();
					if(contact != null) {
						contact.sortByName();
					}
					break;

				case 12:
					contact = getAddressBook();
					if(contact != null) {
						contact.sortByCity();
					}
					break;

				case 13:
					contact = getAddressBook();
					if(contact != null) {
						contact.sortByState();
					}
					break;

				case 14:
					contact = getAddressBook();
					if(contact != null) {
						contact.sortByZip();
					}
					break;

				case 15:
					contact = getAddressBook();
					if(contact != null) {
						System.out.print("Enter file name (example: contacts.txt): ");
						String fileName = sc.nextLine();
						contact.writeToFile(fileName);
					}
					break;

				case 16:
					contact = getAddressBook();
					if(contact != null) {
						System.out.print("Enter file name to read: ");
						String fileName = sc.nextLine();
						contact.readFromFile(fileName);
					}
					break;

				case 17:
					contact = getAddressBook();
					if(contact != null) {
						System.out.print("Enter CSV file name (example: contacts.csv): ");
						String fileName = sc.nextLine();
						executor.submit(() -> {
							contact.writeToCSV(fileName);
						});

					}
					break;

				case 18:
					contact = getAddressBook();
					if(contact != null) {
						System.out.print("Enter CSV file name to read: ");
						String fileName = sc.nextLine();
						contact.readFromCSV(fileName);
					}
					break;

				case 19:
					contact = getAddressBook();
					if(contact != null) {
						System.out.print("Enter JSON file name (example: contacts.json): ");
						String fileName = sc.nextLine();
						executor.submit(() -> {
							contact.writeToJSON(fileName);
						});

					}
					break;

				case 20:
					contact = getAddressBook();
					if(contact != null) {
						System.out.print("Enter JSON file name to read: ");
						String fileName = sc.nextLine();
						contact.readFromJSON(fileName);
					}
					break;

				case 21:
					contact = getAddressBook();
					if(contact != null) {
						System.out.print("Enter First Name to send: ");
						String fname = sc.nextLine();

						for(CreateContact c : contact.getAllContacts()) {
							if(c.getFirstName().equalsIgnoreCase(fname)) {
								executor.submit(() -> {
									contact.sendContactToServer(c);
								});
								break;
							}
						}
					}
					break;

				case 22:
					contact = getAddressBook();
					if(contact != null) {
						contact.fetchContactsFromServer();
					}
					break;

				case 23:
					executor.shutdown();
					System.out.println("Exited");
					System.exit(0);

					
				default :
					System.out.println("Enter the valid choice");
			}
				
		}
		
	}

	// UC-5: Helper method to select Address Book
	private static Contacts getAddressBook() {
        System.out.print("Enter Address Book Name: ");
        String name = sc.nextLine();

        Contacts contact = addressBooks.get(name);
        if(contact == null) {
            System.out.println("Address Book not found");
        }
        return contact;
    }

	// UC-8: Search by City across all Address Books
    private static void searchByCity(String city) {
        boolean found = false;

        for(Map.Entry<String, Contacts> entry : addressBooks.entrySet()) {
            String bookName = entry.getKey();
            Contacts contacts = entry.getValue();
            List<CreateContact> results = contacts.getContactsByCity(city);

            if(!results.isEmpty()) {
                found = true;
                System.out.println("\nAddress Book: " + bookName);
                for(CreateContact c : results) {
                    c.displayInfo();
                }
            }
        }
        if(!found) {
            System.out.println("No contacts found in city: " + city);
        }
    }

    // UC-8: Search by State across all Address Books
    private static void searchByState(String state) {
        boolean found = false;
        for(Map.Entry<String, Contacts> entry : addressBooks.entrySet()) {
            String bookName = entry.getKey();
            Contacts contacts = entry.getValue();
            List<CreateContact> results = contacts.getContactsByState(state);

            if(!results.isEmpty()) {
                found = true;
                System.out.println("\nAddress Book: " + bookName);
                for(CreateContact c : results) {
                    c.displayInfo();
                }
            }
        }
        if(!found) {
            System.out.println("No contacts found in state: " + state);
        }
    }

	// UC-9: Build dictionaries dynamically across all Address Books
	private static void buildDictionaries() {
		cityDictionary.clear();
		stateDictionary.clear();

		for(Contacts contacts : addressBooks.values()) {
			for(CreateContact c : contacts.getAllContacts()) {
				// Add to city dictionary
				cityDictionary.putIfAbsent(c.getCity(), new ArrayList<>());
				cityDictionary.get(c.getCity()).add(c);

				// Add to state dictionary
				stateDictionary.putIfAbsent(c.getState(), new ArrayList<>());
				stateDictionary.get(c.getState()).add(c);
			}
		}
	}

	// UC-9: View all persons by City
	private static void viewPersonsByCity() {
		buildDictionaries();
		System.out.println("\n=== Persons by City ===");

		for(Map.Entry<String, List<CreateContact>> entry : cityDictionary.entrySet()) {
			System.out.println("City: " + entry.getKey());
			for(CreateContact c : entry.getValue()) {
				System.out.println(" - " + c.getFirstName() + " " + c.getLastName());
			}
		}
	}

	// UC-9: View all persons by State
	private static void viewPersonsByState() {
		buildDictionaries();
		System.out.println("\n=== Persons by State ===");

		for(Map.Entry<String, List<CreateContact>> entry : stateDictionary.entrySet()) {
			System.out.println("State: " + entry.getKey());
			for(CreateContact c : entry.getValue()) {
				System.out.println(" - " + c.getFirstName() + " " + c.getLastName());
			}
		}
	}

	// UC-10: Count number of persons by City
	private static void countByCity() {
		buildDictionaries(); // UC-9
		System.out.println("\n=== Count of Persons by City ===");

		for(Map.Entry<String, List<CreateContact>> entry : cityDictionary.entrySet()) {
			System.out.println("City: " + entry.getKey() + " | Count: " + entry.getValue().size());
		}
	}

	// UC-10: Count number of persons by State
	private static void countByState() {
		buildDictionaries(); // UC-9
		System.out.println("\n=== Count of Persons by State ===");

		for(Map.Entry<String, List<CreateContact>> entry : stateDictionary.entrySet()) {
			System.out.println("State: " + entry.getKey() + " | Count: " + entry.getValue().size());
		}
	}

}
