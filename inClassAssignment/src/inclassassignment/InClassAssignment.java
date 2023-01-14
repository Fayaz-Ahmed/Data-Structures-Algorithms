package inclassassignment;

public class InClassAssignment { //test implementation

    public static void main(String[] args) {
        PriorityQueue x = new PriorityQueue();
        x.insert(5);
        x.insert(10);
        x.insert(7);
        x.insert(8);
        x.insert(13);
        x.display();
        try {
            x.delete();
            x.delete();
            x.display();
            System.out.println("Peek is " + x.peek());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

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

class PriorityQueue {

    private DoublyLinkedList queue;

    public PriorityQueue() {
        this.queue = new DoublyLinkedList();
    }

    public void insert(int value) {
        if (this.queue.isEmpty()) {
            this.queue.insertData(value);
        } else {
            this.queue.insertInOrder(value);
        }
    }

    public int delete() throws Exception {
        if (this.queue.isEmpty()) {
            throw new Exception("queue is empty So,Cannot delete");
        } else {
            Node deleted = this.queue.delete();
            return deleted.data;
        }
    }

    public void display() {
        if (this.queue.isEmpty()) {
            System.out.println("queue is empty nothing print");
        } else {
            this.queue.displayList();
        }
    }

    public int peek() throws Exception {
        if (this.queue.isEmpty()) {
            throw new Exception("Queue is empty cannot get front value");
        } else {
            return this.queue.peek();
        }
    }

}
