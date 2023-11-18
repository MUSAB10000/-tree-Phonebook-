public class Appointment implements Comparable<Appointment> {
    private String AppointmentTitle, Location, ContactName;
    private String DataAndTime;
    private Contact Contact_inv;

    public Appointment(String AppointmentTitle, String dateAndTime, String location, Contact Contact_inv) {
        this.AppointmentTitle = AppointmentTitle;
        this.DataAndTime = dateAndTime;
        this.Location = location;
        this.Contact_inv = Contact_inv;
        ContactName = Contact_inv.getContactName();
    }

    public String getAppointmentTitle() {
        return AppointmentTitle;
    }

    public void setEventTitle(String eventTitle) {
        AppointmentTitle = eventTitle;
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
    public int compareTo(Appointment other) {
        return this.AppointmentTitle.compareTo(other.getAppointmentTitle());
    }

    public String toString() {
        String str = "\nEvent title: " + AppointmentTitle +
                "\nContacts names:   " + ContactName +
                "\nEvent date and time (MM/DD/YYYY HH:MM): " + DataAndTime +
                "\nEvent location: " + Location + "\n";
        return str;
    }
}
