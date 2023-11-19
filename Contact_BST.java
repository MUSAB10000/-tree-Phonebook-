public class Contact_BST<T> {
    BSTNode<T> root, current;

    public Contact_BST() {
        root = current = null;
    }

    public boolean empty() {
        return root == null;
    }

    public T retrieve() {
        return current.data;
    }

    public void update(T val) {
        if(removeKey(((Contact)val).getContactName(),(T)val))
         addContact((Contact)val);
	    
     return;
    }
     public void addContact(Contact contact) {
        // If the tree is empty, set the root node as the new contact
        if (root == null) {
            root = new BSTNode<T>(contact.getContactName(), (T)contact);
            System.out.println("Contact added successfully");
        } else {
            // Check if contact already exists
            if (ContactExist(contact))
                System.out.println("Contact already exists");
            // Insert the contact into the BST
            insert(root, contact);
            System.out.println("Contact added successfully");
        }
    }
    
    private void insert(BSTNode<T> node, Contact contact) {
        // If the contact's name is less than the current node's key, go to the left subtree
        if (contact.getContactName().compareTo(node.key) < 0) {
            if (node.left == null) {
                // If the left child is null, create a new node with the contact and set it as the left child
                node.left = new BSTNode<T>(contact.getContactName(), (T)contact);
            } else {
                // Recursively insert into the left subtree
                insert(node.left, contact);
            }
        } else {
            if (node.right == null) {
                // If the right child is null, create a new node with the contact and set it as the right child
                node.right = new BSTNode<T>(contact.getContactName(), (T)contact);
            } else {
                // Recursively insert into the right subtree
                insert(node.right, contact);
            }
        }
    }
    
    private boolean ContactExist(Contact contact) {
        // Check if a contact with the same name or phone number already exists in the BST
        if (find(contact.getContactName(), 1) != null || find(contact.getPhoneNumber(), 2) != null)
            return true;
    
        return false;
    }

    public <T> find(String name, int num) {
        if(empty())
			return null;
        current = root;
        BSTNode<T> q = current;
        
        switch (num) { // start switch
            case 1:
                while (current != null) {// start while
                    int x = ((Contact) current.data).getContactName().compareTo(name);
                    if (x == 0) 
                        return current.data;
                    else if (x == -1)
                        current = current.right;
                    else
                        current = current.left;
                } // end while
                break;
            case 2:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getPhoneNumber().equals(name)) {// start
                                                                                                                    // if
                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 3:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getEmail().equals(name)) {// start
                                                                                                              // if

                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 4:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getAddress().equals(name)) {// start
                                                                                                                // if

                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
            case 5:
                while (current != null) {// start while
                    if (current.data instanceof Contact && ((Contact) current.data).getBirthday().equals(name)) {// start
                                                                                                                 // if

                        return current.data;
                    } // end if
                    current = current.getNext();
                } // end while
                break;
        } // end switch
        current = q;
        return null;
    }// end Search


    public boolean removeKey(String name) {
        // Search for name
        String name1 = name;
        BSTNode<T> p = root;
        BSTNode<T> q = null; // Parent of p
        while (p != null) {
            if (name1.compareTo(p.key) < 0) {
                q = p;
                p = p.left;
            } else if (name1.compareTo(p.key) > 0) {
                q = p;
                p = p.right;
            } else { // Found the key
                // Check the three cases
                if ((p.left != null) && (p.right != null)) {
                    // Case 3: two children
                    // Search for the min in the right subtree
                    BSTNode<T> min = p.right;
                    q = p;
                    while (min.left != null) {
                        q = min;
                        min = min.left;
                    }
                    p.key = min.key;
                    p.data = min.data;
                    name1 = min.key;
                    p = min;
                    // Now fall back to either case 1 or 2
                } // The subtree rooted at p will change here

                if (p.left != null) { // One child
                    p = p.left;
                } else { // One or no children
                    p = p.right;
                }
                if (q == null) { // No parent for p, root must change
                    root = p;
                } else {
                    if (name1.compareTo(p.key) < 0) {
                        q.left = p;
                    } else {
                        q.right = p;
                    }
                }
                current = root;
                return true;
            }
        }
        return false; // Not found
    }
}
