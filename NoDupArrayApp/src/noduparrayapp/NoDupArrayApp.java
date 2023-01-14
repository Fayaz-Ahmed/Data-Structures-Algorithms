/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noduparrayapp;

/**
 *
 * @author fatech98
 */
public class NoDupArrayApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NoDupArray x = new NoDupArray(6);
        x.insert(9);
        x.insert(7);
        x.insert(3);
        x.insert(8);
        x.display();
        x.insert(4);
        x.display();
        x.delete(7);
        x.display();
        System.out.println("find the value 4=" + x.find(10));
        x.insert(3);
        
    }
    
}

class NoDupArray {
    //  0, 1, 2, 3, 4, 5

    private long[] a;//[9, 7, 6, 2, _, _]
    private int nEliments;//4

    public NoDupArray(int max) {
        this.a = new long[max];
        this.nEliments = 0;
    }
    
    public boolean find(long SearchKey) {//[9, 7, 6, 2, _, _]
        for (int i = 0; i < this.nEliments; i++) {
            if (this.a[i] == SearchKey) {
                return true;
            }
        }
        return false;
    }
    
    public void insert(long value) {
        if (this.nEliments == this.a.length) {
            System.out.println("Array is full insertion terminated");
        } else {
            if (find(value)) {
                System.out.println("value already exists. insertion terminated");
            } else {
                a[this.nEliments] = value;
                this.nEliments++;
            }
        }
    }
    
    public boolean delete(long value) {
        for (int i = 0; i < this.nEliments; i++) {
            if (this.a[i] == value) {
                for (int j = i; j < this.nEliments - 1; j++) {
                    this.a[j] = this.a[j + 1];
                }
                this.nEliments--;
                System.out.println("value deleted");
                return true;
            }
        }
        System.out.println("value not found");
        return false;
    }
    
    public void display() {
        System.out.println("----values in the array----");
        for (int i = 0; i < this.nEliments; i++) {
            System.out.print(this.a[i] + " ");
        }
        System.out.println();
    }
}
