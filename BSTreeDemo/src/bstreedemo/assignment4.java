package bstreedemo;

public class assignment4 {

    public static void main(String[] args) {
        PriorityQueueBSTree x1 = new PriorityQueueBSTree();

        x1.enqueue(new Student("Saman", 2.8));
        x1.enqueue(new Student("Kamal", 2.0));
        x1.enqueue(new Student("Oshadee", 1.7));
        x1.enqueue(new Student("Vijitha", 1.9));
        x1.enqueue(new Student("Sandun", 3.1));
        x1.enqueue(new Student("Johan", 3.0));
        x1.enqueue(new Student("Riyana", 3.5));
        x1.enqueue(new Student("Gayani", 3.6));
        x1.enqueue(new Student("Sathira", 3.8));

        x1.displayStudents(x1.root);
        System.out.println();
        x1.dequeue();
        x1.displayStudents(x1.root);

    }
}

class Student {

    String studentName;
    double gpa;
    Student leftChild;
    Student rightChild;

    Student(String studentName, double gpa) {
        /*fill the code*/
        this.studentName = studentName;
        this.gpa = gpa;
        this.rightChild = null;
        this.leftChild = null;

    }

    @Override
    public String toString() {
        return studentName + "(" + gpa + ")";
    }
}

class PriorityQueueBSTree {

    Student root;

    public void enqueue(Student s) {
        /*add the student to the relevant place of the queue*/
        if (this.root == null) {

            this.root = s;

        } else {

            Student cur = this.root;

            while (cur != null) {

                if (s.gpa > cur.gpa) {

                    if (cur.rightChild == null) {

                        cur.rightChild = s;

                        return;
                    }

                    cur = cur.rightChild;

                } else {

                    if (cur.leftChild == null) {

                        cur.leftChild = s;

                        return;
                    }

                    cur = cur.leftChild;
                }
            }
        }

    }

    public Student dequeue() {
        /*remove the front student and return the removed student*/

        Student frontStudent;

        if (this.root == null) {

            System.out.println("Queue is empty .no students are in queue");

            return null;

        }

        if (this.root.rightChild == null) {

            frontStudent = root;

            this.root = this.root.leftChild;

            return frontStudent;

        } else {
            frontStudent = this.root.rightChild;
            
            Student parentStudent = this.root;

            while (frontStudent != null) {

                if (frontStudent.rightChild == null) {

                    break;

                }

                parentStudent = frontStudent;

                frontStudent = frontStudent.rightChild;

            }

            parentStudent.rightChild = frontStudent.leftChild;

            return frontStudent;
        }
    }

    public void displayStudents(Student currentNode) {
        /*display all the student names in the queue
Sample output of this method according to the above sample figure 01.
Sathira(3.8)
Gayani(3.6)
Riyana(3.5)
Sandun(3.1)
Johan(3.0)
Saman(2.8)
Kamal(2.0)
Vijitha(1.9)
Oshadee(1.7)
         */
        if (currentNode != null) {

            displayStudents(currentNode.rightChild);

            System.out.println(currentNode);

            displayStudents(currentNode.leftChild);

        }
    }

}

