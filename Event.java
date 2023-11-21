public class Event implements Comparable<Event> {
    private String EventTitle, Location;
    private String DataAndTime;
    private boolean isAppointment;
    public Contact_BST<Contact> contacts;

    public Event(String eventTitle, String dateAndTime, String location,String contactsName , boolean isAppointment) {
        this.EventTitle = eventTitle;
        this.DataAndTime = dateAndTime;
        this.Location = location;
        this.isAppointment = isAppointment;
        contacts=new Contact_BST<>();

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

    public String getContactName() {
        return ContactName;
    }

    public void setContactsName(Contact_BST<Contact> contacts,String contactsName) {
        String Firstname = "";
        for (int i = 0; i < contactsName.length(); i++) {
            if (contactsName.substring(i, i) != ",")
                Firstname += contactsName.substring(i, i);
            else{
                Contact contact = contacts.find(Firstname, 1);
                contacts.addContact(contacts.find(Firstname, i));
                Firstname = "";
            }
        }
    }
    

    public boolean isAppointment() {
        return isAppointment;
    }

    public void setAppointment(boolean appointment) {
        isAppointment = appointment;
    }
    
    public void addC(Contact other) {
      contacts.addContact(other);
     }

     public boolean removeContact(String name){
        if(isAppointment)
         return false;

          return contacts.removeKey(name);

     }

    @Override
    public int compareTo(Event other) {
        return this.EventTitle.compareTo(other.getEventTitle());
    }

    public String toString() {//needs edit
        String str = "\nEvent title: " + EventTitle +
                "\nContacts names:   " + ContactName +
                "\nEvent date and time (MM/DD/YYYY HH:MM): " + DataAndTime +
                "\nEvent location: " + Location + "\n";
        return str;
    }
}
