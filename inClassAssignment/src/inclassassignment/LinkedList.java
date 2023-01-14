package inclassassignment;

class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }

    void displayNode() {
        System.out.print(this.data + " ");
    }

    void displayDetailedNode() {
        System.out.println("Current: " + this.data);
        if (this.next != null) {
            System.out.println("Next: " + this.next.data);
        }
        if (this.prev != null) {
            System.out.println("Previous: " + this.prev.data);
        }
        System.out.println("    ");
    }
}

class DoublyLinkedList {

    private Node head;

    public DoublyLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    public void insertData(int i) {
        Node node = new Node(i);
        if (this.head != null) {
            this.head.prev = node;
        }
        node.next = this.head;
        this.head = node;
    }

    public void insertInOrder(int value) {
        Node node = new Node(value);

        if (this.head.data > node.data) {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        } else {
            Node item = this.head;
            while (item.next != null) {
                if (item.next.data > node.data) {
                    node.next = item.next;
                    item.next.prev = node;
                    item.next = node;
                    return;
                }
                item = item.next;
            }
            item.next = node;
        }
    }

    public Node delete() {
        if (isEmpty()) {
            System.out.println("Doubly Linked List is empty");
            return null;
        } else {
            Node deletedValue = this.head;
            this.head = this.head.next;

            deletedValue.next = null;
            return deletedValue;
        }
    }

    public int peek() {
        return this.head.data;
    }

    public void displayList() {

        if (isEmpty()) {
            System.out.println("Doubly Linked List is empty");
            return;
        }

        Node item = this.head;

        while (item != null) {
            item.displayNode();
            item = item.next;
        }

        System.out.println();
    }

}
