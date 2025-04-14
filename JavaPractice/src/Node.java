public class Node {
    private int id;
    private Node next;
    private Node prev;

    public Node(int id) {
        this.id = id;
        this.next = null;
    }

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
    }
    
    public int getId() {
        return id;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }
}
