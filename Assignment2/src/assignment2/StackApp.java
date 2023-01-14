/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 174093G
 */
public class StackApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StackArray x = new StackArray(6);
        x.push(7);
        x.push(8);
        x.push(3);
        x.push(5);
        x.push(-1);
        x.display();
        try {
            x.peek();
        } catch (Exception ex) {
        }
        //x.display();
        try {
            x.pop();
        } catch (Exception ex) {
        }
        x.display();
    }

}

class StackArray {

    private int maxSize;
    private int[] stackData;
    private int top;

    public StackArray(int s) {
        this.stackData = new int[s];
        this.maxSize = s;
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }

    public void push(int j) {
        //this.stackData[++this.top]=j;
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        this.stackData[this.top + 1] = j;
        this.top++;
    }

    public int pop() throws Exception {
        //top--;
        if (isEmpty()) {
            throw new Exception("Empty stack cannot pop");
        }
        return stackData[top--];
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty stack cannot pop");
        }

        //System.out.println(stackData[top]);
        return stackData[top];
    }

    public void display() {

        for (int i = top; i >= 0; i--) {
            System.out.println(stackData[i] + " ");
        }
        System.out.println();
    }
}
