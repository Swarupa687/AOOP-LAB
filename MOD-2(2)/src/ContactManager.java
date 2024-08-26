import java.util.*;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    // Constructor
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Override equals and hashCode for uniqueness
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) &&
                Objects.equals(phoneNumber, contact.phoneNumber) &&
                Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, email);
    }

    // toString for easy printing
    @Override
    public String toString() {
        return "Contact{name='" + name + "', phoneNumber='" + phoneNumber + "', email='" + email + "'}";
    }
}

public class ContactManager {
    // Set to store unique contacts
    private Set<Contact> contactSet;
    
    // Map to associate names with contacts
    private Map<String, Contact> nameToContactMap;

    // Constructor
    public ContactManager() {
        this.contactSet = new HashSet<>();
        this.nameToContactMap = new HashMap<>();
    }

    // Method to add a contact
    public void addContact(Contact contact) {
        if (contactSet.add(contact)) {
            nameToContactMap.put(contact.getName(), contact);
        } else {
            System.out.println("Contact already exists: " + contact);
        }
    }

    // Method to remove a contact by name
    public void removeContact(String name) {
        Contact contact = nameToContactMap.remove(name);
        if (contact != null) {
            contactSet.remove(contact);
            System.out.println("Removed contact: " + contact);
        } else {
            System.out.println("Contact not found with name: " + name);
        }
    }

    // Method to find a contact by name
    public Contact findContactByName(String name) {
        return nameToContactMap.get(name);
    }

    // Method to list all contacts
    public void listContacts() {
        for (Contact contact : contactSet) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();

        // Adding contacts
        Contact contact1 = new Contact("Alice", "123-456-7890", "alice@example.com");
        Contact contact2 = new Contact("Bob", "234-567-8901", "bob@example.com");
        Contact contact3 = new Contact("Charlie", "345-678-9012", "charlie@example.com");

        manager.addContact(contact1);
        manager.addContact(contact2);
        manager.addContact(contact3);

        // Listing contacts
        System.out.println("All Contacts:");
        manager.listContacts();

        // Finding a contact by name
        System.out.println("\nFinding Contact by Name 'Bob':");
        Contact foundContact = manager.findContactByName("Bob");
        if (foundContact != null) {
            System.out.println("Found: " + foundContact);
        } else {
            System.out.println("Contact not found.");
        }

        // Removing a contact
        System.out.println("\nRemoving Contact 'Alice':");
        manager.removeContact("Alice");

        // Listing contacts after removal
        System.out.println("\nAll Contacts After Removal:");
        manager.listContacts();
    }
}