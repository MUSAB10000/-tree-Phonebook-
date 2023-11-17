public class Contact implements Comparable<Contact> {
    private String ContactName;
    private String PhoneNumber;
    private String Email;
    private String address;
    private String Birthday;
    private String notes;

    public Contact(String contactName, String phoneNumber, String email, String address, String birthday,
            String notes) {
        this.ContactName = contactName;
        this.PhoneNumber = phoneNumber;
        this.Email = email;
        this.address = address;
        this.Birthday = birthday;
        this.notes = notes;
    }

    public Contact(String contactName) {
        this.ContactName = contactName;

    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = PhoneNumber;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int compareTo(Contact other) {
        return this.ContactName.compareTo(other.ContactName);
    }

    public String toString() {
        return "\nName: " + ContactName +
                "\nPhone Number: " + PhoneNumber +
                "\nEmail Address: " + Email +
                "\nAddress: " + address +
                "\nBirthday: " + Birthday +
                "\nNotes: " + notes + "\n";
    }

}
