
class Patient {

    String patientName;
    int priority;
    Patient next;

    Patient(String patientName, int priority) {
        this.patientName = patientName;
        this.priority = priority;
        this.next = null;
    }

}

class PriorityQueue {

    private Patient head;
    private Patient tail;

    public void enqueue(String patientName, int priority) {
        Patient patient = new Patient(patientName, priority);
        if (this.head == null) {
            this.head = patient;
            this.tail = this.head;
        } else {
            if (patient.priority < this.head.priority) {
                patient.next = this.head;
                this.head = patient;
            } else {
                Patient curr = this.head;
                while (curr.next != null) {
                    if (patient.priority < curr.next.priority) {
                        patient.next = curr.next;
                        curr.next = patient;
                        return;
                    }
                    curr = curr.next;
                }
                curr.next = patient;
                this.tail = curr.next;
            }
        }
    }

    public String dequeue() throws Exception {
        if (this.head == null) {
            throw new Exception("Queue is empty cannot remove");
        } else {
            String nameOfpatient = this.head.patientName;
            this.head = this.head.next;
            return nameOfpatient;
        }
    }

    public String peek() throws Exception {
        if (this.head == null) {
            throw new Exception("Queue is empty cannot get peek");
        } else {
            return this.head.patientName;
        }
    }

    public void display() { 
        if (this.head == null) {
            System.out.println("Queue is empty cannot display");
            return;
        }

        Patient curr = this.head;

        while (true) {
            System.out.println(curr.patientName);
            if (curr.next == null) {
                return;
            }
            curr = curr.next;
        }
    }

}
