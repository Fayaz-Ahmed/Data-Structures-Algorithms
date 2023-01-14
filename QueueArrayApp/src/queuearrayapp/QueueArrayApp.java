/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuearrayapp;

/**
 * @author fatech98
 */
public class QueueArrayApp {

    public static void main(String[] args) {
        QueueArray x = new QueueArray(5);
        PriorityQueue y = new PriorityQueue(4);
        //     x.display();
        x.insert(2);
        x.insert(8);
        x.insert(3);
        x.display();
//        try {
//            x.dequeue();
//            x.display();
//            x.enqueue(23);
//            x.enqueue(45);
//            x.enqueue(59);
//            x.display();
//
//            x.display();
//            x.dequeue();
//            x.enqueue(89);
//            x.display();
//            System.out.println("Peek is " + x.peek());
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//        y.insert1(9);
//        y.insert1(2);
//        y.insert1(10);
//        y.insert1(3);
//        y.insert1(20);
//        y.disPri();
    }

}

class QueueArray {

    private int maxSize;
    private int[] arr;
    private int front;
    private int rear;
    private int n;

    public QueueArray(int s) {
        this.arr = new int[s];
        this.maxSize = s;
        this.front = 0;
        this.rear = -1;
        this.n = 0;
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public boolean isFull() {
        return this.n == this.maxSize;
    }

    public int size() {
        return this.n;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full cannot insert");
            return;
        }
//        if (this.rear == this.maxSize - 1) {
//            this.rear = 0;
//        } else {
//            this.rear++;
//        }
        rear = (rear + 1) % maxSize;
        this.arr[rear] = value;
        this.n++;

    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % maxSize;
        this.arr[rear] = item;
        this.n++;
        return true;
    }

    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty cannot remove ");
        }
        int removedItem = this.arr[front];
//        if (this.front == this.maxSize - 1) {
//            this.front = 0;
//        } else {
//            front++;
//        }
        front = (front + 1) % maxSize;
        n--;
        return removedItem;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty cannot get front value ");
        }
        return this.arr[this.front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("queue is empty nothing print");
            return;
        }
        int i = this.front;
        while (i != rear) {
            System.out.print(this.arr[i] + " ");
//            if (i == maxSize - 1) {
//                i = 0;
//            } else {
//                i++;
//            }
            i = (i + 1) % maxSize;
        }
        System.out.print(this.arr[rear]);
        System.out.println();

    }
}
//-priority queue

class PriorityQueue {

    private int MAX;
    private int[] arr;
    private int n;

    public PriorityQueue(int w) {
        this.arr = new int[w];
        this.MAX = w;
        this.n = 0;
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public boolean isFull() {
        return this.n == this.MAX;
    }

    public int size() {
        return this.n;
    }

    public void insert(int val) {
        if (isFull()) {
            System.out.println("Queue is full cannot insert");
            return;
        }
        int i;
        if (n == 0) {
            arr[0] = val;
            n++;
            return;
        }
        for (i = n - 1; i >= 0; i--) {
            if (val > arr[i]) {
                arr[i + 1] = arr[i];

            } else {
                break;
            }
        }
        arr[i + 1] = val;
        n++;
    }

    public void insert1(int val) {
        if (isFull()) {
            System.out.println("Queue is full cannot insert");
            return;
        }
        int i;
        if (n == 0) {
            arr[0] = val;
            n++;
            return;
        }
        for (i = n - 1; i >= 0; i--) {
            if (val < arr[i]) {
                arr[i + 1] = arr[i];

            } else {
                break;
            }
        }
        arr[i + 1] = val;
        n++;
    }

    public void disPri() {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - // ... }

