import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Contacts {
	private ArrayList<CreateContact> contacts;
	
	public Contacts() {
		contacts = new ArrayList<>();
	}
	
	// UC-1/UC-7: Add Contact with Duplicate Check
    void addContact(CreateContact contact) {

        if(contacts.contains(contact)) {
            System.out.println("Duplicate Contact Found. \nCannot Add.");
            return;
        }

        contacts.add(contact);
        System.out.println("Contact Added Successfully");
    }
	
	// UC-2: Display Contacts
	void displayContact() {
		if(contacts.isEmpty()) {
			System.out.println("No contacts found");
		} 
		
		for(CreateContact contact : contacts) {
			contact.displayInfo();
		}
		
	}
	
	// UC-3: Edit Contact
	void editContact(String firstName, String lastName, Scanner sc) {
		boolean found = false;
		for(int i=0; i<contacts.size(); i++) {
			CreateContact c = contacts.get(i);
			if(c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)) {
				System.out.print("Enter new address: ");
				c.setAddress(sc.nextLine());
				System.out.print("Enter the new city: ");
				c.setCity(sc.nextLine());
				System.out.print("Enter the new state: ");
				c.setState(sc.nextLine());
				System.out.print("Enter the new zip code: ");
				c.setZip(sc.nextInt());
				System.out.print("Enter the new phoneNumber: ");
				c.setPhoneNumber(sc.nextLong());
				sc.nextLine();
				System.out.print("Enter the email: ");
				c.setEmail(sc.nextLine());
				
				found = true;
			}
		}
		
		if(found) {
			System.out.println("Contact updated successfully");
		} else {
			System.out.println("No contact found");
		}
	}

	// UC-4: Delete Contact
	void deleteContact(String firstName, String lastName) {
		boolean found = false;
		
		for(int i=0; i<contacts.size(); i++) {
			CreateContact c = contacts.get(i);
			if(c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)) {
				contacts.remove(i);
				found = true;
			}
		}
		if(found) {
			System.out.print("Contact deleted successfully");
		} else {
			System.out.println("Contact not found");
		}
	}

	// UC-8: Search by City
    List<CreateContact> getContactsByCity(String city) {
        List<CreateContact> result = new ArrayList<>();

        for(CreateContact c : contacts) {
            if(c.getCity().equalsIgnoreCase(city)) {
                result.add(c);
            }
        }
        return result;
    }

    // UC-8: Search by State
    List<CreateContact> getContactsByState(String state) {
        List<CreateContact> result = new ArrayList<>();

        for(CreateContact c : contacts) {
            if(c.getState().equalsIgnoreCase(state)) {
                result.add(c);
            }
        }
        return result;
    }

	// Uc-9: Get All Contacts
	List<CreateContact> getAllContacts() {
		return new ArrayList<>(contacts); 
	}

	// UC-11: Sorting contacts by name 
	public void sortByName() {
		Collections.sort(contacts, new Comparator<CreateContact>() {
			@Override
			public int compare(CreateContact c1, CreateContact c2) {
				return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
			}
		});

		System.out.println("\nContacts Sorted by First Name:\n");
		for(CreateContact c : contacts) {
			System.out.println(c);  
		}
	}

	// UC-12: Sorting by category
	public void sortByCity() {
		contacts.sort(Comparator.comparing(CreateContact::getCity, String.CASE_INSENSITIVE_ORDER));
		System.out.println("\nContacts Sorted by City:\n");
		contacts.forEach(System.out::println);
	}

	public void sortByState() {
		contacts.sort(Comparator.comparing(CreateContact::getState, String.CASE_INSENSITIVE_ORDER));
		System.out.println("\nContacts Sorted by State:\n");
		contacts.forEach(System.out::println);
	}

	public void sortByZip() {
		contacts.sort(Comparator.comparingInt(CreateContact::getZip));
		System.out.println("\nContacts Sorted by Zip:\n");
		contacts.forEach(System.out::println);
	}

	// UC-13
	public void writeToFile(String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

			for(CreateContact c : contacts) {
				writer.write(c.getFirstName() + "," +
							c.getLastName() + "," +
							c.getAddress() + "," +
							c.getCity() + "," +
							c.getState() + "," +
							c.getZip() + "," +
							c.getPhoneNumber() + "," +
							c.getEmail());
				writer.newLine();
			}

			System.out.println("Contacts saved successfully to file.");

		} catch(IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
	}

	public void readFromFile(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

			String line;

			while((line = reader.readLine()) != null) {
				String[] data = line.split(",");

				CreateContact contact = new CreateContact(
						data[0],
						data[1],
						data[2],
						data[3],
						data[4],
						Integer.parseInt(data[5]),
						Long.parseLong(data[6]),
						data[7]
				);

				contacts.add(contact);
			}

			System.out.println("Contacts loaded successfully from file.");

		} catch(IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}

	public void writeToCSV(String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

			// Header
			writer.write("FirstName,LastName,Address,City,State,Zip,Phone,Email");
			writer.newLine();

			for(CreateContact c : contacts) {
				writer.write(c.getFirstName() + "," +
							c.getLastName() + "," +
							c.getAddress() + "," +
							c.getCity() + "," +
							c.getState() + "," +
							c.getZip() + "," +
							c.getPhoneNumber() + "," +
							c.getEmail());
				writer.newLine();
			}

			System.out.println("Contacts saved as CSV successfully.");

		} catch(IOException e) {
			System.out.println("Error writing CSV: " + e.getMessage());
		}
	}

	public void readFromCSV(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

			String line;
			reader.readLine(); // Skip header

			while((line = reader.readLine()) != null) {

				String[] data = line.split(",");

				CreateContact contact = new CreateContact(
						data[0],
						data[1],
						data[2],
						data[3],
						data[4],
						Integer.parseInt(data[5]),
						Long.parseLong(data[6]),
						data[7]
				);

				contacts.add(contact);
			}

			System.out.println("Contacts loaded from CSV successfully.");

		} catch(IOException e) {
			System.out.println("Error reading CSV: " + e.getMessage());
		}
	}

	public void writeToJSON(String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

			writer.write("[");
			writer.newLine();

			for(int i = 0; i < contacts.size(); i++) {
				CreateContact c = contacts.get(i);

				writer.write("  {");
				writer.newLine();
				writer.write("    \"firstName\": \"" + c.getFirstName() + "\",");
				writer.newLine();
				writer.write("    \"lastName\": \"" + c.getLastName() + "\",");
				writer.newLine();
				writer.write("    \"address\": \"" + c.getAddress() + "\",");
				writer.newLine();
				writer.write("    \"city\": \"" + c.getCity() + "\",");
				writer.newLine();
				writer.write("    \"state\": \"" + c.getState() + "\",");
				writer.newLine();
				writer.write("    \"zip\": " + c.getZip() + ",");
				writer.newLine();
				writer.write("    \"phoneNumber\": " + c.getPhoneNumber() + ",");
				writer.newLine();
				writer.write("    \"email\": \"" + c.getEmail() + "\"");
				writer.newLine();
				writer.write("  }");

				if(i < contacts.size() - 1) {
					writer.write(",");
				}
				writer.newLine();
			}

			writer.write("]");
			writer.newLine();

			System.out.println("Contacts saved as JSON successfully.");

		} catch(IOException e) {
			System.out.println("Error writing JSON: " + e.getMessage());
		}
	}

	public void readFromJSON(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

			String line;
			String firstName = "", lastName = "", address = "", city = "", state = "", email = "";
			int zip = 0;
			long phoneNumber = 0;

			while((line = reader.readLine()) != null) {

				line = line.trim();

				if(line.startsWith("\"firstName\"")) {
					firstName = line.split(":")[1].replace("\"", "").replace(",", "").trim();
				}
				else if(line.startsWith("\"lastName\"")) {
					lastName = line.split(":")[1].replace("\"", "").replace(",", "").trim();
				}
				else if(line.startsWith("\"address\"")) {
					address = line.split(":")[1].replace("\"", "").replace(",", "").trim();
				}
				else if(line.startsWith("\"city\"")) {
					city = line.split(":")[1].replace("\"", "").replace(",", "").trim();
				}
				else if(line.startsWith("\"state\"")) {
					state = line.split(":")[1].replace("\"", "").replace(",", "").trim();
				}
				else if(line.startsWith("\"zip\"")) {
					zip = Integer.parseInt(line.split(":")[1].replace(",", "").trim());
				}
				else if(line.startsWith("\"phoneNumber\"")) {
					phoneNumber = Long.parseLong(line.split(":")[1].replace(",", "").trim());
				}
				else if(line.startsWith("\"email\"")) {
					email = line.split(":")[1].replace("\"", "").trim();

					// Once email is read → object is complete
					CreateContact contact = new CreateContact(
							firstName, lastName, address, city, state, zip, phoneNumber, email
					);

					contacts.add(contact);
				}
			}

			System.out.println("Contacts loaded from JSON successfully.");

		} catch(IOException e) {
			System.out.println("Error reading JSON: " + e.getMessage());
		}
	}

	public void sendContactToServer(CreateContact c) {
		try {
			URL url = new URL("http://localhost:3000/contacts");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);

			String jsonInput = "{"
					+ "\"firstName\":\"" + c.getFirstName() + "\","
					+ "\"lastName\":\"" + c.getLastName() + "\","
					+ "\"address\":\"" + c.getAddress() + "\","
					+ "\"city\":\"" + c.getCity() + "\","
					+ "\"state\":\"" + c.getState() + "\","
					+ "\"zip\":" + c.getZip() + ","
					+ "\"phoneNumber\":" + c.getPhoneNumber() + ","
					+ "\"email\":\"" + c.getEmail() + "\""
					+ "}";

			OutputStream os = conn.getOutputStream();
			os.write(jsonInput.getBytes());
			os.flush();
			os.close();

			int responseCode = conn.getResponseCode();
			System.out.println("POST Response Code: " + responseCode);

			conn.disconnect();

		} catch (Exception e) {
			System.out.println("Error sending data: " + e.getMessage());
		}
	}

	public void fetchContactsFromServer() {
		try {
			URL url = new URL("http://localhost:3000/contacts");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(conn.getInputStream())
			);

			String line;
			StringBuilder response = new StringBuilder();

			while((line = reader.readLine()) != null) {
				response.append(line);
			}

			reader.close();
			conn.disconnect();

			System.out.println("Server Response:");
			System.out.println(response.toString());

		} catch (Exception e) {
			System.out.println("Error fetching data: " + e.getMessage());
		}
	}

}
