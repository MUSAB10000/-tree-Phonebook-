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

    public void add(T val) {
        if (val instanceof Event) {
            System.out.println(addEvent((Event) val));
            return;
        }
        System.out.println("Can't add this type.");
    }

    private String addEvent(Event e) {
        if (head == null) {
            head = new Node<T>((T) e);
            return "Event added successfully!";
        }
        if (dateTimeConflictEvent(head, e)) // new edit
            return "Event Not Adeed! DateAndTime Conflict";

        if (head.getData() instanceof Event && e.compareTo(((Event) head.getData())) < 0) {
            Node<T> temp = head;
            head = new Node<T>((T) e);
            head.setNext(temp);
            return "Event added successfully!";
        }
        Node<T> newNode = new Node<T>((T) e);
        current = head;
        Node<T> prev = null;
        while (current != null) {
            if (current.getData() instanceof Event && e.compareTo((Event) current.getData()) < 0) {
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

    private boolean dateTimeConflictEvent(Node<T> head, Event event) {// cheack if there is an event that has the same
        // DateAndTime and the same name, Assuming the name of
        // contact is unique.
        current = head;
        while (current != null) {
            if (current.getData() instanceof Event) {
                Event existingEvent = (Event) current.getData();
                if (existingEvent.getDataAndTime().equalsIgnoreCase(event.getDataAndTime()))
                    return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void RemoveEvent(String ContactEvent) {
        if (head == null) {
            return;
        }
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (((Event) current.data).isAppointment())
                if (((Event) current.data).getcontactsName().equalsIgnoreCase(ContactEvent))
                    if (previous != null) {
                        previous.setNext(current.getNext());
                        current = current.getNext();
                    } else {
                        head = current.getNext();
                        current = head;
                    }
                else {
                    previous = current;
                    current = current.getNext();
                }

            else {
                Contact x = (((Event) current.data).contacts.find(ContactEvent, 1));
                if (x == null) {
                    previous = current;
                    current = current.getNext();
                } else {
                    ((Event) current.data).removeContact(x.getContactName());
                }
            }
        }
    }

    public void SearchEvent(Node<T> head, String name, int num) { // start PrintEvent
        if (head == null)
            return;

        current = head;
        switch (num) { // start switch
            case 1:
                while (current != null) {// start while
                    if (((Event) current.getData()).Getcontacts().find(name, 1) != null)
                        current.data.toString();

                    current = current.getNext();
                } // end while
                break;
            case 2:
                while (current != null) {// start while
                    if (current.data instanceof Event && ((Event) current.data).getEventTitle().equals(name))
                        current.data.toString();
                    current = current.getNext();
                } // end while
                break;
        } // end switch
    }

}
