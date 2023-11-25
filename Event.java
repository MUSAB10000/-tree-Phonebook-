public class Event implements Comparable<Event> {
    private String EventTitle, Location, contactsName;
    private String DataAndTime;
    private boolean isAppointment;
    public Contact_BST<Contact> contacts;

    public Event(String eventTitle, String dateAndTime, String location,String contactsName , boolean isAppointment) {
        this.EventTitle = eventTitle;
        this.DataAndTime = dateAndTime;
        this.Location = location;
        this.isAppointment = isAppointment;
        this.contactsName = contactsName;
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

    public Contact_BST<Contact> Getcontacts() {
        return contacts;
    }
    
    public String getcontactsName() {
        return contactsName;
    }

    public boolean setContactsName(Contact_BST<Contact> contacts, Contact_BST<Contact> Contacts1, String contactsName1) {
        String Firstname = "";


        if(isAppointment){
            Contact con = Contacts1.find(Firstname, 1);
               if (con != null) {
                    contacts.addContact(con);
                    return true;  
                }   
                return false;
        }
        String c = contactsName1;
        int index = 0;
		for (int i = 0; i < contactsName1.length(); i++) {
			if ( i == 0) {
				index = c.indexOf(',');
				if (index == -1)
	            	break;
				Firstname +=c.substring(0, index);
				c=c.substring(index+1,c.length());
			}
			else {
				index = c.indexOf(',');
				if (index == -1)
	            	break;
	            Firstname +=c.substring(0, index);
	            c=c.substring(index+1,c.length());
			}

            Contact con = Contacts1.find(Firstname, 1);
            if (con != null) {
                contacts.addContact(con);
                Firstname = "";
            }
                else
                return false;
        } //end for
                Contact con = Contacts1.find(c, 1);
                if (con != null) {
                contacts.addContact(con);
                return true;
                }
                else
                return false;
            
    }
    

    public boolean isAppointment() {
        return isAppointment;
    }

    public void setAppointment(boolean appointment) {
        isAppointment = appointment;
    }
    
    

    public boolean removeContact(String name){
      

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
