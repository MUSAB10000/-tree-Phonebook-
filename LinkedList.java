public class LinkedList<T> { // start LinkedList
    private Node<T> head;
    private Node<T> current;

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current.getNext() == null;
    }

    public void findfirst() {
        current = head;
    }

    public void findnext() {
        current = current.getNext();
    }

    public T retrieve() {
        return current.getData();
    }

    public Node<T> getHead() {
        return head;
    }

    public String addEvent(Event e) {// O(n)
        if (head == null) {// O(1)
            head = new Node<T>((T) e);
            return "Event added successfully!";
        }
        if (dateTimeConflictEvent(head, e))// O(n)
            return "Event Not Adeed! DateAndTime Conflict";

        if (e.getEventTitle().compareToIgnoreCase(((Event) head.getData()).getEventTitle()) < 0) {// O(1)
            Node<T> temp = head;
            head = new Node<T>((T) e);
            head.setNext(temp);
            return "Event added successfully!";
        }
        Node<T> newNode = new Node<T>((T) e);
        current = head;
        Node<T> prev = null;
        while (current != null) {// O(n)
            if (e.getEventTitle().compareToIgnoreCase(((Event) head.getData()).getEventTitle()) < 0) {
                newNode.setNext(current);
                prev.setNext(newNode);
                current = newNode;
                return "Event added successfully!";
            }
            prev = current;
            current = current.getNext();
        }

        if (current == null) {
            prev.setNext(newNode);
            current = head;
            return "Event added successfully!";
        }

        return "Event Not Adeed!";

    }

    private boolean dateTimeConflictEvent(Node<T> head, Event event) {// cheack if there is an event that has the same DateAndTime
        current = head;
        while (current != null) {
            Event existingEvent = (Event) current.getData();
            if (existingEvent.getDataAndTime().equalsIgnoreCase(event.getDataAndTime())) {
                return true; // Conflict found
            }
            current = current.getNext();
        }

        return false; // No conflict
    }

    public void RemoveEvent(String ContactEvent) {// O(nm)
        if (head == null) {
            return;
        }
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (((Event) current.data).isAppointment()) {// the delete method for Appointment
                if (((Event) current.data).getcontactsName().equalsIgnoreCase(ContactEvent)) {
                    if (previous != null) {
                        previous.setNext(current.getNext());
                        current = current.getNext();
                    } else {
                        head = current.getNext();
                        current = head;
                    }
                } else {
                    previous = current;
                    current = current.getNext();
                }
            } else {// delete method for Event
                Contact x = (((Event) current.data).contacts.find_name(ContactEvent));
                if (x == null) {
                    previous = current;
                    current = current.getNext();
                } else {
                    ((Event) current.data).Getcontacts().removeContact(x.getContactName());
                    ((Event) current.data).removenamecontact(x.getContactName());
                    String contactNames = ((Event) current.data).getcontactsName();

                    if (contactNames.isEmpty() || contactNames.equals(",")
                            || containsOnlySpacesOrCommas(contactNames)) {
                        // Delete the event node if the contact names contain only spaces or commas
                        if (previous != null) {
                            previous.setNext(current.getNext());
                            current = current.getNext();
                        } else {
                            head = current.getNext();
                            current = head;
                        }
                    } else {
                       
                        previous = current;
                        current = current.getNext();
                    }
                }
            }
        }

       
    }

    public void SearchEvent(Node<T> head, String name, int num) { // O(n)
        if (head == null)
            return;

        current = head;
        switch (num) { // start switch
            case 1:
                while (current != null) {// start while
                    if (((Event) current.getData()).Getcontacts().find_name(name) != null)
                        System.out.println(current.data.toString());

                    current = current.getNext();
                } // end while
                break;
            case 2:
                while (current != null) {// start while
                    if (current.data instanceof Event && ((Event) current.data).getEventTitle().equals(name))
                        System.out.println(current.data.toString());

                    current = current.getNext();
                } // end while
                break;
        } // end switch
    }

    public boolean containsOnlySpacesOrCommas(String str) {
        boolean allSpacesOrCommas = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && str.charAt(i) != ',') {
                allSpacesOrCommas = false;
                break;
            }
        }
        return allSpacesOrCommas;
    }
}
