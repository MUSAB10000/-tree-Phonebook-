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
        if (val instanceof Appointment) {
            System.out.println(addAppointment((Appointment) val));
            return;
        }
        if (val instanceof Event) {
            System.out.println(addEvent((Event) val));
            return;
        }
        System.out.println("Can't add this type.");
    }

    private String addAppointment(Appointment e) {
        if (head == null) {
            head = new Node<T>((T) e);
            return "Event added successfully!";
        }
        if (dateTimeConflictAppointment(head, e)) // new edit
            return "Event Not Adeed! DateAndTime Conflict";

        if (head.getData() instanceof Appointment && e.compareTo(((Appointment) head.getData())) < 0) {
            Node<T> temp = head;
            head = new Node<T>((T) e);
            head.setNext(temp);
            return "Event added successfully!";
        }
        Node<T> newNode = new Node<T>((T) e);
        current = head;
        Node<T> prev = null;
        while (current != null) {
            if (current.getData() instanceof Appointment && e.compareTo((Appointment) current.getData()) < 0) {
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
                if (existingEvent.getContactName().equalsIgnoreCase(event.getContactName())
                        && existingEvent.getDataAndTime().equalsIgnoreCase(event.getDataAndTime()))
                    return true;
            }
            current = current.getNext();
        }
        return false;
    }

    private boolean dateTimeConflictAppointment(Node<T> head, Appointment event) {// cheack if there is an event that
                                                                                  // has the same
        // DateAndTime and the same name, Assuming the name o // contact is unique.
        current = head;
        while (current != null) {
            if (current.getData() instanceof Event) {
                Appointment existingEvent = (Appointment) current.getData();
                if (existingEvent.getContactName().equalsIgnoreCase(event.getContactName())
                        && existingEvent.getDataAndTime().equalsIgnoreCase(event.getDataAndTime()))
                    return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void RemoveAppointment(String ContactAppointment) {
        if (head == null) {
            return;
        }

        if (head.data instanceof Appointment
                && ((Appointment) head.data).getContactName().equalsIgnoreCase(ContactAppointment)) {
            head = head.getNext();
            return;
        }

        current = head;
        while (current != null && current.getNext() != null) {
            if (current.getNext().data instanceof Appointment) {
                if (((Appointment) current.getNext().data).getContactName().equalsIgnoreCase(ContactAppointment)) {
                    if (current.getNext().getNext() != null) {
                        current.setNext(current.getNext().getNext());
                    } else {
                        current.setNext(null);
                    }
                    return;
                }
            }
            current = current.getNext();
        }
    }

    public void RemoveEvent(String ContactEvent) {
        if (head == null) {
            return;
        }

        while (head != null && head.data instanceof Event
                && ((Event) head.data).getContactName().equalsIgnoreCase(ContactEvent)) {
            head = head.getNext();
        }
        Node<T> current = head;

        while (current != null && current.getNext() != null) {
            if (current.getNext().data instanceof Event
                    && ((Event) current.getNext().data).getContactName().equalsIgnoreCase(ContactEvent)) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
    }

    public T SearchEvent(Node<T> head, String name, int num) { // start PrintEvent
        if (head == null) { // start if
            return null;
        } // end if
        current = head;
        switch (num) { // start switch
            case 1:
                while (current != null) {// start while
                    if (current.data instanceof Event && ((Event) current.data).getContactName().equals(name)) {// start
                                                                                                                // if
                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 2:
                while (current != null) {// start while
                    if (current.data instanceof Event && ((Event) current.data).getEventTitle().equals(name)) {// start
                                                                                                               // if

                        System.out.println("Event found!");
                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
        } // end switch

        return null;

    }

}