/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackarrayapp;

/**
 *
 * @author fatech98
 */
public class StackArrayApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StackArray sa = new StackArray(6);
        sa.push(7);
        sa.push(3);
        sa.push(2);
        sa.push(9);
        sa.push(8);
        sa.display();
        sa.push(1);
        sa.push(5);
        try {
            // int k = sa.peek();
            System.out.println("peek is " + sa.peek());
            System.out.println("poped an item:" + sa.pop());
            System.out.println("poped an item:" + sa.pop());
            System.out.println("poped an item:" + sa.pop());
            System.out.println("poped an item:" + sa.pop());
            System.out.println("poped an item:" + sa.pop());
            System.out.println("poped an item:" + sa.pop());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        StackArrayApp s = new StackArrayApp();
        System.out.println("Binary value of 50: ");
        s.decimalToBinary(50);
    }

    public void decimalToBinary(int n) {
        int temp = n;
        int count = 0;
        while (temp != 0) {
            temp = temp / 2;
            count++;
        }
        StackArray myStack = new StackArray(count);
        temp = n;
        while (temp != 0) {
            int rem = temp % 2;
            temp = temp / 2;
            myStack.push(rem);
        }
        // myStack.display();
        while (!myStack.isEmpty()) {
            try {
                System.out.print(myStack.pop());
            } catch (Exception e) {

            }
        }
        System.out.println();
    }

}

class StackArray {          

    private int maxSize; //size of stack array
    private int[] stackData;
    private int top; //top of stack
//-------------------------------------------------------------------------

    public StackArray(int s) {
        this.stackData = new int[s];
        this.maxSize = s;
        this.top = -1;
    }

    public boolean isEmpty() {
        if (top == -1) {//return top==-1;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (top == maxSize - 1) {//return top == maxSize - 1
            return true;
        } else {
            return false;
        }
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is already full");
            return;
        }
        // top++;
        stackData[++top] = item;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty cannot pop");
        }  
        return stackData[top--];
    }  

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return stackData[top];
    }

    public void display() {
        System.out.println("Start printing stack data");
        for (int i = top; i >= 0; i--) {
            System.out.println(stackData[i]);
        }
        System.out.println("end printing stack data ");
        System.out.println();
    }
}
