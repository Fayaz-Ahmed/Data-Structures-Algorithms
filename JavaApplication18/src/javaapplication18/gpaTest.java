package javaapplication18;

public class gpaTest {

    public static void main(String[] args) {
        PriorityQueue prioqueue = new PriorityQueue();
        prioqueue.enqueue("Fayas", 3.2);
        prioqueue.enqueue("Nuzra", 3.9);
        prioqueue.enqueue("Mifdha", 3.8);
        prioqueue.enqueue("Razan", 3.9);
        prioqueue.enqueue("Shaja", 3.7);
        prioqueue.enqueue("Nifla", 3.9);
        prioqueue.display();
        try {
            System.out.println("Dequeued: " + prioqueue.dequeue());
            System.out.println("Dequeued: " + prioqueue.dequeue());

            System.out.println("Peek : " + prioqueue.peek());
        } catch (Exception e) {
            System.out.println(e);
        }
        prioqueue.display();

    }
}

class Student {

    String studentName;
    double gpa;

    Student(String studentName, double gpa) {
        this.studentName = studentName;
        this.gpa = gpa;
    }

}

class Node {

    Student s;
    Node next;

    Node(Student s) {
        this.s = s;
        this.next = null;
    }

}

class PriorityQueue {

    private Node head;
    private Node tail;

    public void enqueue(String studentName, double gpa) {
        Node student = new Node(new Student(studentName, gpa));
        if (this.head == null) {
            this.head = student;
            this.tail = this.head;
        } else {
            if (gpa > this.head.s.gpa) {
                student.next = this.head;
                this.head = student;
            } else {
                Node curr = this.head;
                while (curr.next != null) {
                    if (gpa > curr.next.s.gpa) {
                        student.next = curr.next;
                        curr.next = student;
                        return;
                    }
                    curr = curr.next;
                }
                curr.next = student;
                this.tail = curr.next;
            }
        }
    }

    public String dequeue() throws Exception {
        if (this.head == null) {
            throw new Exception("Queue is empty cannot remove");
        } else {
            String nameOfStudent = this.head.s.studentName;
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
            return nameOfStudent;
        }
    }

    public String peek() throws Exception {
        if (this.head == null) {
            throw new Exception("Queue is empty cannot get peek");
        } else {
            return this.head.s.studentName;
        }
    }

    public void display() {
        if (this.head == null) {
            System.out.println("Queue is empty cannot show ");
            return;
        }

        Node curr = this.head;

        while (true) {
            System.out.println(curr.s.studentName);
            if (curr == this.tail) {
                return;
            }
            curr = curr.next;
        }
    }

}
