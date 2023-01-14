/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordarrayapp;

/**
 *
 * @author fatech98
 */
public class OrdArrayApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        OrdArray x = new OrdArray(7);
        x.insert(2);
        x.insert(9);
        x.insert(7);
        x.insert(3);
        x.display();
        x.insert(1);
        x.insert(7);
        x.insert(6);
        x.display();
        x.delete(3);
        x.display();
        x.delete(7);
        x.display();

    }

}

class OrdArray {

    private long[] a;
    private int nElements;

    public OrdArray(int max) {
        this.a = new long[max];//size=7
        this.nElements = 0;//5
    }

    public int size() {
        return this.a.length;
    }

    //[0, 1, 2,  3,  4,   ,  ] indexes
    public int find(long searchKey) {//[1, 5, 7, 10, 13, _, _] arrays //7
        for (int i = 0; i < this.nElements; i++) {
            if (this.a[i] == searchKey) {
                return i;// here we can return the index value
            }
        }
        return -1;
    }

    //[0, 1, 2,  3,  4,  5, 6] indexes
    public void insert(long value) {//[1, 5, 7, 10, 13, 15, _] arrays  //8
        if (this.nElements == size()) {
            System.out.println("array is full, inserting terminated.");
            return;
        }
        for (int i = 0; i < this.nElements; i++) {
            if (this.a[i] > value) {
                for (int j = this.nElements - 1; j >= i; j--) {
                    //this.a[j+1]=this.a[j];
                    // this.a[nElements + 1] = this.a[nElements];
                    this.a[j + 1] = this.a[j];
                }
                this.a[i] = value;
                this.nElements++;
                return;
            }
        }
        a[this.nElements] = value;
        this.nElements++;
    }

    public boolean delete(long value) {
        int index = find(value);
        if (index == -1) {
            System.out.println("value is not found,deletion terminated");
            return false;
        } else  {
            for (int i = index; i < this.nElements - 1; i++) {
                this.a[i] = this.a[i + 1];
            }
            this.nElements--;
            return true;
        }
    
    }

    void display() {
        System.out.println("--values of the array---");
        for (int i = 0; i < this.nElements; i++) {
            System.out.print(this.a[i] + " ");
        }
        System.out.println();
    }
}
