public class Event implements Comparable<Event> {
    private String EventTitle, Location, ContactName;
    private String DataAndTime;
    private Contact Contact_inv;

    public Event(String eventTitle, String dateAndTime, String location, Contact Contact_inv) {
        this.EventTitle = eventTitle;
        this.DataAndTime = dateAndTime;
        this.Location = location;
        this.Contact_inv = Contact_inv;
        ContactName = Contact_inv.getContactName();
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

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public Contact getContact_inv() {
        return Contact_inv;
    }

    public void setContact_inv(Contact Contact_inv) {
        this.Contact_inv = Contact_inv;
    }

    @Override
    public int compareTo(Event other) {
        return this.EventTitle.compareTo(other.getEventTitle());
    }

    public String toString() {
        String str = "\nEvent title: " + EventTitle +
                "\nContacts names:   " + ContactName +
                "\nEvent date and time (MM/DD/YYYY HH:MM): " + DataAndTime +
                "\nEvent location: " + Location + "\n";
        return str;
    }
}
