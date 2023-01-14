/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplesortingapp;

/**
 *
 * @author fatech98
 */
public class SimpleSortingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SimpleSorting k = new SimpleSorting(7);
        k.insert(4);
        k.insert(8);
        k.insert(1);
        k.insert(3);
        k.display();
        k.insertionSort();
        k.display();
       
        //k.countSwaps(3);
    }

}

class SimpleSorting {

    private int[] a;//ref to array a
    private int nElems;//number of data items
    //------------------------------------------------------

    public SimpleSorting(int max) {
        this.a = new int[max];
        this.nElems = 0;
    }

    public void insert(int value) {
        if (nElems == a.length) {
            System.out.println("array is full");
            return;
        }
        this.a[this.nElems] = value;
        this.nElems++;
    }

    public void display() {
        System.out.println("array elements");
        for (int i = 0; i < this.nElems; i++) {
            System.out.print(this.a[i] + " ");
        }
        System.out.println();
    }
    //[0,1,2,3,4,5] 

    private void swap(int index1, int index2) {//[2,3,4,5,6,8]
        int temp;
        temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public void bubbleSort() {
//Fill the body
        for (int i = 0; i < nElems - 1; i++) {
            for (int j = 0; j < (nElems - 1) - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
        System.out.println("Numbers are sorted using Bubble sort...");
    }

    public void selectionSort() {

        for (int i = 0; i < nElems - 1; i++) {
            int minIndex = i;//we assume this is minimum value
            for (int j = i + 1; j < nElems; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
                swap(i, minIndex);
            }
            swap(i, minIndex);
        }
        System.out.println("Numbers are sorted using SELECTION sort...");
    }

    public void countSwaps(int[] a) {
        int nElems = a.length;
        int numberOfSwaps = 0;

        for (int i = 0; i < nElems - 1; i++) {
            for (int j = 0; j < (nElems - 1) - i; j++) {
                if (a[j] > a[j + 1]) {
                    // swap(j, j + 1);
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    numberOfSwaps += 1;
                }
            }
        }
        System.out.println("Array is sorted in " + numberOfSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[nElems - 1]);

    }

    public void insertionSort() {
//Fill the body
        for (int i = 1; i < nElems; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0) {
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
                j--;
            }
            a[j + 1] = temp;
        }
    }
}
