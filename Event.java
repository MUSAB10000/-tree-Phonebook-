public class Event implements Comparable<Event> {
    private String EventTitle, Location, contactsName;
    private String DataAndTime;
    private boolean isAppointment;
    public Contact_BST<Contact> contacts;

    public Event(String eventTitle, String dateAndTime, String location, String contactsName, boolean isAppointment) {
        this.EventTitle = eventTitle;
        this.DataAndTime = dateAndTime;
        this.Location = location;
        this.isAppointment = isAppointment;
        this.contactsName = contactsName;
        contacts = new Contact_BST<>();

    }

    public String getEventTitle() {
        return EventTitle;
    }

    public void setEventTitle(String eventTitle) {
        EventTitle = eventTitle;
    }

    public String getDataAndTime() {
        return DataAndTime;
    }

    public void setDataAndTime(String dataAndTime) {
        DataAndTime = dataAndTime;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Contact_BST<Contact> Getcontacts() {
        return contacts;
    }

    public String getcontactsName() {
        return contactsName;
    }

    public boolean setContactsName(Contact_BST<Contact> contactsBST, Contact_BST<Contact> Contacts1,
            String contactsName1) {// O(n)
        // Split contact names by comma
        String[] contactNames = contactsName1.split(",");
        for (int i = 0; i < contactNames.length; i++) {
            Contact contact = Contacts1.find_name(contactNames[i]);
            if (contact != null) {
                contacts.addContact(contact);
            } else {
                // Contact not found, return false indicating failure to add event
                return false;
            }
        }
        return true; // All contacts added successfully
    }

    public boolean isAppointment() {
        return isAppointment;
    }

    public void setAppointment(boolean appointment) {
        isAppointment = appointment;
    }

    public void removenamecontact(String contactsName1) {// O(n)
        String[] contactNames = contactsName.split(contactsName1);
        contactsName = "";
        for (int i = 0; i < contactNames.length; i++) {
            contactsName += contactNames[i];
        }
    }

    @Override
    public int compareTo(Event other) {
        return this.EventTitle.compareTo(other.getEventTitle());
    }

    public String toString() {
        if (isAppointment) {
            String str = "\nAppointment title: " + EventTitle +
                    "\nContact name:   " + contactsName +
                    "\nAppointment date and time (MM/DD/YYYY HH:MM): " + DataAndTime +
                    "\nAppointment location: " + Location + "\n";
            return str;
        }

        String str = "\nEvent title: " + EventTitle +
                "\nContact names:   " + contactsName +
                "\nEvent date and time (MM/DD/YYYY HH:MM): " + DataAndTime +
                "\nEvent location: " + Location + "\n";
        return str;
    }

}
