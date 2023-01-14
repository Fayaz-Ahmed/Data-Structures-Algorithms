/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclassassignment;

/**
 *
 * @author fatech98
 */
public class doublyLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    class Node {

        int data;
        Node previous;
        Node next;

        public Node(int item) {
            this.data = item;
            this.previous = null;
            this.next = null;
        }

        void display() {

            System.out.print(this.data + " ");
        }

    }
    Node head;

    public doublyLinkedList(Node head) {
        this.head = head;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }

    }

    public void InsertEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
            node.previous = curr;
        }
    }

    public void InsertStart(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
    }

    public Node deleteStart() {
        Node node = head;
        if (head == null || head.next == null) {
            head = null;
            return node;
        }
        head = head.next;
        head.previous = null;
        return node;
    }

    public Node deleteEnd() {
        Node node = head;
        if (head == null || head.next == null) {
            head = null;
            return node;
        }
        while (node.next != null) {
            node = node.next;
        }
        return node.previous.next = null;
    }

    public void displayList() {
        //go to each node and print one by one
        Node current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println("");
    }

}
