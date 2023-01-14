/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nondupintarrayapp;

/**
 *
 * @author Fayaz Ahamed
 */
public class NonDupintArrayApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NonDupIntArray x = new NonDupIntArray(8);
        x.insert(2);
        x.insert(3);
        x.insert(4);
        x.insert(5);
        x.insert(6);
        x.insert(7);
        x.display();
         x.delete(4);
       x.display();
      
        // System.out.println("find the value 4=" + x.find(4));

    }

}

class NonDupIntArray {

    private int[] ary; // ref to array ary
    private int nElems; // number of data items
//--------------------------------------------------

    public NonDupIntArray(int max) { // constructor
        this.ary = new int[max];
        this.nElems = 0;
    }

//--------------------------------------------------
    public int size() {
        return this.ary.length;
    }
//--------------------------------------------------

    public int find(int value) {
        for (int i = 0; i < this.nElems; i++) {
            if (this.ary[i] == value) {
                return i;// here we can return the index value
            }
        }
        return -1;
    }
//--------------------------------------------------

    public void insert(int value) {

        if (this.nElems == this.ary.length) {
            System.out.println("Array is full insertion terminated");
            return;
        }
        if (find(value) != -1) {
            System.out.println("value already exists. inserting terminated");

        } else {
            ary[this.nElems] = value;
            this.nElems++;
        }
    }

//--------------------------------------------------
//    public boolean delete(int location) {
//        if (location >= this.nElems) {
//            System.out.println("There is nos location " + location);
//            return false;
//        } else {
//            for (int i = location; i < this.nElems - 1; i++) {
//                this.ary[i] = this.ary[i + 1];
//            }
//            this.nElems--;
//            System.out.println("value is deleted");
//            return true;
//        }
//    }
    public boolean delete(int location) {
        if ( location<this.nElems) {
            for (int i = 0; i < this.nElems; i++) {
                if (i == location) {
                    for (int j = i; j < this.nElems - 1; j++) {
                        this.ary[j] = this.ary[j + 1];
                    }
                    this.nElems--;
                    System.out.println("value deleted");
                    return true;
                }
            }
        }
        System.out.println("value not found");
        return false;
    }

// end delete ()
//--------------------------------------------------
    public void display() { // display array contents
//Fill the body (10 Marks)
        System.out.println("----values in the array----");
        for (int i = 0; i < this.nElems; i++) {
            System.out.print(this.ary[i] + " ");
        }
        System.out.println();
    }

//--------------------------------------------------
}
