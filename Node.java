public class Node<w> {
    w data;
    private Node<w> next;

    public w getData() {
        return data;
    }

    public void setData(w data) {
        this.data = data;
    }

    public Node<w> getNext() {
        return next;
    }

    public void setNext(Node<w> next) {
        this.next = next;
    }

    public Node(w data) {
        this.data = data;
        this.next = null;
    }
}