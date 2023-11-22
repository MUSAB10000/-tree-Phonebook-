public class Event implements Comparable<Event> {
    private String EventTitle, Location, contactsName;
    private String DataAndTime;
    private boolean isAppointment;
    public Contact_BST<Contact> contacts;

    public Event(String eventTitle, String dateAndTime, String location,String contactsName , boolean isAppointment, Contact_BST Contacts1) throws Exception {
        this.EventTitle = eventTitle;
        this.DataAndTime = dateAndTime;
        this.Location = location;
        this.isAppointment = isAppointment;
        this.contactsName = contactsName;
        contacts=new Contact_BST<>();
        if (setContactsName(contacts,Contacts1,contactsName) == false)
        throw new Exception("Contact not found");
        
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

    public boolean setContactsName(Contact_BST<Contact> contacts, Contact_BST<Contact> Contacts1, String contactsName1) {
        String Firstname = "";
        for (int i = 0; i < contactsName1.length(); i++) {
            if (contactsName1.substring(i, i) != ",")
                Firstname += contactsName1.substring(i, i);
            else{
                Contact con = contacts.find(Firstname, 1);
                if (con != null) {
                contacts.addContact(con);
                Firstname = "";
                }
                else
                return false;
            }
        }
        return true;
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

    public String toString() {
         if(isAppointment){
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
