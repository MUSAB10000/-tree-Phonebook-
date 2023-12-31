
public class Contact_BST<T> {
    private BSTNode<T> root, current;

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
        if (removeContact(((Contact) val).getContactName()))
            addContact((Contact) val);

        return;
    }

    public BSTNode getroot() {
        return root;
    }

    public Boolean addContact(Contact contact) {// average case O(log n) worst case O(n)
        // If the tree is empty, set the root node as the new contact
        if (root == null) {// O(1)
            root = new BSTNode<T>(contact.getContactName(), (T) contact);
            return true;
        } else {
            // Check if contact already exists
            if (ContactExist(contact)) {// O(log n)
                return false;
            }
            // Insert the contact into the BST
            insert(root, contact);// average case O(log n) worst case O(n)
            return true;
        }
    }

    private void insert(BSTNode<T> node, Contact contact) {
        // If the contact's name is less than the current node's key, go to the left
        // subtree
        if (contact.getContactName().compareTo(node.key) < 0) {
            if (node.left == null) {
                // If the left child is null, create a new node with the contact and set it as
                // the left child
                node.left = new BSTNode<T>(contact.getContactName(), (T) contact);
            } else {
                // Recursively insert into the left subtree
                insert(node.left, contact);
            }
        } else {
            if (node.right == null) {
                // If the right child is null, create a new node with the contact and set it as
                // the right child
                node.right = new BSTNode<T>(contact.getContactName(), (T) contact);
            } else {
                // Recursively insert into the right subtree
                insert(node.right, contact);
            }
        }
    }

    private boolean ContactExist(Contact contact) {
        // Check if a contact with the same name or phone number already exists in the
        // BST
        if (find_name(contact.getContactName()) != null || find_Others(root,contact.getPhoneNumber(), 2) != null)
            return true;

        return false;
    }

    public T find_name(String name) {// average case O(log n) worst case O(n)
        if (empty())
            return null;
        current = root;
        BSTNode<T> q = (BSTNode<T>) current;
        while (current != null) {

            if (name.compareTo(((Contact) current.data).getContactName()) == 0)
                return retrieve();
            else if (name.compareTo(((Contact) current.data).getContactName()) < 0)
                current = current.left;
            else
                current = current.right;
        }
        return null;

    }// end Search

    public T find_Others(BSTNode<T> node, String name, int num) {// average case O(log n) worst case O(n)
        if (empty()) {
            return null;
        }
        current = root;
        BSTNode<T> q = (BSTNode<T>) current;
        switch (num) {
            case 2: 
                    T val = null;
                    if (name.equalsIgnoreCase(((Contact) node.data).getPhoneNumber())) {
                        current = node;
                        return retrieve();
                    }
                    if (node.left != null) {
                        val = find_Others(node.left,name, num);
                        if (val != null)
                        return val;
                    } if (node.right != null) {
                        val = find_Others(node.right,name, num);
                        if (val != null)
                        return val;
                    } else {
                        return null;
                    }
                

            case 3:
                    val = null;
                    if (name.equalsIgnoreCase(((Contact) node.data).getEmail())) {
                        current = node;
                        return retrieve();
                    }
                    if (node.left != null) {
                        val = find_Others(node.left,name, num);
                        if (val != null)
                        return val;
                    } if (node.right != null) {
                        val = find_Others(node.right,name, num);
                        if (val != null)
                        return val;
                    } else {
                        return null;
                    }
                
            case 4:
                  val = null;
                    if (name.equalsIgnoreCase(((Contact) node.data).getAddress())) {
                        current = node;
                        return retrieve();
                    }
                    if (node.left != null) {
                        val = find_Others(node.left,name, num);
                        if (val != null)
                        return val;
                    } if (node.right != null) {
                        val = find_Others(node.right,name, num);
                        if (val != null)
                        return val;
                    } else {
                        return null;
                    }
            case 5:
                  val = null;
                    if (name.equalsIgnoreCase(((Contact) node.data).getAddress())) {
                        current = node;
                        return retrieve();
                    }
                    if (node.left != null) {
                        val = find_Others(node.left,name, num);
                        if (val != null)
                        return val;
                    } if (node.right != null) {
                        val = find_Others(node.right,name, num);
                        if (val != null)
                        return val;
                    } else {
                        return null;
                    }

        }
        return null;

    }

    public boolean removeContact(String name1) {// average case O(log n) worst case O(n)
        // Search for name
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
                    if (name1.compareTo(q.key) < 0) {
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
