/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistapp;

/**
 *
 * @author fatech98
 */

public class LinkedListApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkList x = new LinkList();
        x.insertFirst(5);
        x.insertFirst(9);
        x.insertFirst(3);
        x.insertFirst(7);
        x.displayList();
        x.deleteFirst();
        x.displayList();
        
    }
}

class Node {
    
    int data;
    Node next;
    
    Node(int item) {
        this.data = item;
        this.next = null;
    }
    
    void displayNode() {
        System.out.print(this.data + " ");
    }
}

class LinkList {
    
    private Node head;
    
    public LinkList() {
        head = null;
    }
    
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void insertFirst(int i) {
        Node newNode = new Node(i);
        newNode.next = head;
        head = newNode;
    }
    
    public Node deleteFirst() {
        if (isEmpty()) {
            System.out.println("empty list");
            return null;
        }
        Node temp = head;
        head = head.next;//new had is equal to previous head next
        temp.next = null;//for security purpose
        return temp;
    }
    
    public void displayList() {
        if (isEmpty()) {
            System.out.println("empty list");
            return;
        }
        Node cur = head;
        while (cur != null) {
            cur.displayNode();
            cur = cur.next;
        }
        System.out.println();
    }
    
    public Node find(int key) {//key==position
        Node cur = head;
        int count = 0;
        while (cur != null) {
            if (count == key) {
                // return cur;
                Node temp = new Node(cur.data);// for security purpose
                return temp;
            }
            cur = cur.next;
            count++;
        }
        System.out.println("item not found");
        return null;
    }
    
    public void delete(int key) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node cur = head;
        Node pre = head;
        int count = 1;
        while (cur != null) {
            if (count == key) {
                if (count == 1) {
                    deleteFirst();
                } else {
                    pre.next = cur.next;
                }
                System.out.println("deleted");
                return;
            }
            pre = cur;
            cur = cur.next;
            count++;
        }
        System.out.println("no items");
    }
}
