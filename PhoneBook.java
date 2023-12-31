import java.util.Scanner;

public class PhoneBook {

    Contact_BST<Contact> contacts;
    LinkedList<Event> events;
    public Scanner input = new Scanner(System.in);

    public PhoneBook() {
        contacts = new Contact_BST<Contact>();
        events = new LinkedList<>();
    }

    public void display() {
        int choice = 0;
        System.out.println("Welcome to the Linked Tree Phonebook!\n");
        do {
            System.out.println(
                    "Please choose an option:\n" +
                            "1. Add a contact\n" +
                            "2. Search for a contact\n" +
                            "3. Delete a contact\n" +
                            "4. Schedule an event\n" +
                            "5. Print event details\n" +
                            "6. Print contacts by first name\n" +
                            "7. Print all events alphabetically\n" +
                            "8. Exit\n");
            System.out.println("Enter your choice:");
            choice = input.nextInt();// Assuming the user is reasnoable user

            switch (choice) {// start big switch
                case 1:
                    System.out.print("Enter the contact's name: ");
                    String name = input.next();
                    name += input.nextLine();
                    System.out.print("\nEnter the contact's phone number: ");
                    String phoneNumber = input.next();
                    System.out.print("\nEnter the contact's email address: ");
                    String email = input.next();

                    System.out.print("Enter the contact's address: ");
                    String address = input.next();
                    address += input.nextLine();
                    System.out.print("Enter the contact's birthday: ");
                    String birthday = input.next();
                    System.out.print("Enter any notes for the contact: ");
                    String notes = input.next();
                    notes += input.nextLine();
                    Contact x = new Contact(name, phoneNumber, email, address, birthday, notes);
                    if (contacts.addContact(x)) {
                        System.out.println("Contact added successfully");
                    } else
                        System.out.println("Contact already exists");
                    break;

                case 2:
                    System.out.print("Enter search criteria:\n" +
                            "1. Name\n" +
                            "2. Phone Number\n" +
                            "3. Email Address\n" +
                            "4. Address\n" +
                            "5. Birthday\n" +
                            "Enter your choice: ");
                    int choice2 = input.nextInt();
                    switch (choice2) {// start small switch
                        case 1:
                            System.out.println("Enter the contact's name:");
                            name = input.next();
                            name += input.nextLine();
                            Contact c = contacts.find_name(name);
                            if (c != null) {
                                System.out.println("contact found!");
                                System.out.println(c.toString());
                            } else
                                System.out.println("contact not found!");
                            break;
                        case 2:
                            System.out.println("Enter the contact's phone number:");
                            phoneNumber = input.next();
                            c = contacts.find_Others(contacts.getroot(),phoneNumber, choice2);
                            if (c != null) {
                                System.out.println("contact found!");
                                System.out.println(c.toString());
                            } else
                                System.out.println("contact not found!");

                            break;
                        case 3:
                            System.out.println("Enter the contact's email address:");
                            email = input.next();
                            email += input.nextLine();
                            c = contacts.find_Others(contacts.getroot(),email, choice2);
                            if (c != null) {
                                System.out.println("contact found!");
                                System.out.println(c.toString());
                            } else
                                System.out.println("contact not found!");

                            break;
                        case 4:
                            System.out.println("Enter the contact's address: ");
                            address = input.next();
                            address += input.nextLine();
                            c = contacts.find_Others(contacts.getroot(),address, choice2);
                            if (c != null) {
                                System.out.println("contact found!");
                                System.out.println(c.toString());
                            } else
                                System.out.println("contact not found!");

                            break;
                        case 5:
                            System.out.println("Enter the contact's birthday: ");
                            birthday = input.next();
                            c = contacts.find_Others(contacts.getroot(),birthday, choice2);
                            if (c != null) {
                                System.out.println("contact found!");
                                System.out.println(c.toString());
                            } else
                                System.out.println("contact not found!");

                            break;
                        default:
                            System.out.println("Wrong number, please do it again");
                            break;
                    }// end small switch
                    break;
                case 3:
                    System.out.println("Enter contact name to delete it ");
                    String name_to_delete = input.next();
                    name_to_delete += input.nextLine();
                    if (events.empty()) {
                        contacts.removeContact(name_to_delete);
                        System.out.println("delete contact");

                        break;
                    } else {
                        if (contacts.find_name(name_to_delete) != null) {
                            events.RemoveEvent(name_to_delete);
                            contacts.removeContact(name_to_delete);
                            System.out.println("delete contact");
                            break;
                        } else {
                            System.out.println("Contact name Not Found!");
                            break;
                        }
                    }
                case 4:// needs edit
                    System.out.print("Enter type:\r\n" + //
                            "1. event\r\n" + //
                            "2. appointment\r\n" + //
                            "Enter your choice:");
                    int choice3 = input.nextInt();
                    while (choice3 != 1 && choice3 != 2) {
                        System.out.println("Wrong number, please do it again");
                        choice3 = input.nextInt();
                    }
                    if (choice3 == 1) {
                        System.out.print("Enter event title: ");
                        String eventTitle = input.next();
                        eventTitle += input.nextLine();
                        System.out.print("Enter contacts name separated by a comma: ");
                        String contactName = input.next();
                        contactName += input.nextLine();
                        System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
                        String dateTime = input.next();
                        dateTime += input.nextLine();
                        System.out.print("Enter event location: ");
                        String location = input.next();
                        location += input.nextLine();
                        Event event1 = new Event(eventTitle, dateTime, location, contactName, false);
                        boolean contactsAdded = event1.setContactsName(event1.contacts, contacts, contactName);

                        if (!contactsAdded) {
                            System.out.println("One or more contacts not found. Event scheduling failed.");
                            break;
                        }

                        System.out.println(events.addEvent(event1));

                    } else {
                        System.out.print("Enter appointment title: ");
                        String eventTitle = input.next();
                        eventTitle += input.nextLine();
                        System.out.print("Enter contact name: ");
                        String contactName = input.next();
                        contactName += input.nextLine();
                        System.out.print("Enter appointment date and time (MM/DD/YYYY HH:MM): ");
                        String dateTime = input.next();
                        dateTime += input.nextLine();
                        System.out.print("Enter appointment location: ");
                        String location = input.next();
                        location += input.nextLine();

                        Event event1 = new Event(eventTitle, dateTime, location, contactName, true);
                        boolean contactsAdded = event1.setContactsName(event1.contacts, contacts, contactName);

                        if (!contactsAdded) {
                            System.out.println("One or more contacts not found. Event scheduling failed.");
                            break;
                        }

                        System.out.println(events.addEvent(event1));
                    }
                    break;
                case 5:
                    System.out.println("Enter search criteria:\r\n" + //
                            "1. contact name\r\n" + //
                            "2. Event tittle");
                    choice2 = input.nextInt();
                    switch (choice2) {
                        case 1:
                            System.out.println("Enter the Contact Name:");
                            String contactName = input.next();
                            contactName += input.nextLine();
                            events.SearchEvent(events.getHead(), contactName, choice2);
                            break;
                        case 2:
                            System.out.println("Enter the event title:");
                            String eventTitle = input.next();
                            eventTitle += input.nextLine();
                            events.SearchEvent(events.getHead(), eventTitle, choice2);
                            break;
                        default:
                            System.out.println("Wrong number, please do it again");
                    }
                    break;

                case 6:
                    System.out.println("Enter the First Name you want to search for:");

                    String FName = input.next();

                    printByFirstName(FName);
                    break;
                case 7:
                    PrintAllEvent();
                    break;

                case 8:
                    break;
                default:
                    System.out.println("Wrong number, please do it again");

            } // end big switch
        } while (choice != 8);

        System.out.println("Goodbye !");

    }

    private String extractFirstName(String name) {
        int index = name.indexOf(' ');
        if (index != -1) {
            return name.substring(0, index);
        }
        return name;
    }

    private void printByFirstName(String name) {
        if (contacts.empty()) {
            System.out.println("No Contacts found!");
            return;
        }

        printContactsByFirstName(contacts.getroot(), name);
    }

    private void printContactsByFirstName(BSTNode<Contact> node, String name) {
        if (node != null) {
            String firstName = extractFirstName(node.data.getContactName());// we should to cheack before run the
                                                                            // program

            if (name.compareToIgnoreCase(firstName) < 0) {
                printContactsByFirstName(node.left, name);
            } else if (name.compareToIgnoreCase(firstName) > 0) {
                printContactsByFirstName(node.right, name);
            } else {
                System.out.println(node.data.toString() + "\n");
                // In case multiple contacts have the same first name, you might want to
                // traverse both left and right subtrees.
                printContactsByFirstName(node.left, name);
                printContactsByFirstName(node.right, name);
            }
        }
    }

    private void PrintAllEvent() {
        if (events.empty()) {
            System.out.println("There is No Event right now");
            return;
        }
        events.findfirst();
        while (events.last() == false) {
            System.out.println(events.retrieve().toString());
            events.findnext();
        }
        System.out.println(events.retrieve().toString());

    }

}
