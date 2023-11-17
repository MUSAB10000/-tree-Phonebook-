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
        current.data = val;
    }

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
