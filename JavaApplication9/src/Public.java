
class Student {

    String studentName;

    double gpa;

    Student(String studentName, double gpa) {
        this.studentName = studentName;
        this.gpa = gpa;
        //fill the body
    }

}

class Node {

    Student s;

    Node next;

    Node(Student s) {
        this.s = s;
        this.next = null;
        //fill the body
    }

}

class PriorityQueue {

    private Node head;

    private Node tail;

    public void enqueue(String studentName, double gpa) {
        Student s = new Student(studentName, gpa);
        Node student = new Node(s);
        if (head == null) {
            this.head = student;
            this.tail = this.head;
        } else {
            if (gpa > this.head.s.gpa) {
                student.next = this.head;
                this.head = student;
            } else {
                // Node current = new Node(this.head.s);
                Node current = this.head;
                //   current=current.next;
                while (current.next != null) {
                    if (gpa > current.next.s.gpa) {
                        student.next = current.next;
                        current.next = student;
                        return;

                    }
                    current = current.next;
                }
                current.next = student;
                this.tail = current.next;
            }
        }
    }

    public String dequeue() throws Exception {
        if (this.head == null) {
            throw new Exception("cannoot delete");
        } else {
            Node deletedValue = this.head;

            this.head = this.head.next;

            deletedValue.next = null;

            return deletedValue.s.studentName;
        }

    }

    public String peek() throws Exception {

        //return the name of the front student
        if (this.head == null) {
            throw new Exception("Queue is empty cannot get peek");
        } else {
         return this.head.s.studentName;
        }
    }

    public void display() {

        //display all the student names in the queue
        if(this.head==null){
            System.out.println("Queue is empty cannot display");
            return;
        } 
        Node current = this.head;
        
        
        
    }

}
