/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivedemo;

/**
 *
 * @author fatech98
 */
public class RecursiveDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RecursiveDemo x = new RecursiveDemo();
     x.SolveHanoi(2, 'A', 'B', 'C');
     
    }

    public int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    public int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public int multi(int a, int b) {// 5,4
        if (b == 0) {
            return 0;
        }
        if (b == 1) {
            return a;
        }
        return a + multi(a, b - 1);
    }

//    public int fibo(int term) {// itterative way of get fabinoaci series
//        if (term < 2) {
//            return term;
//        } else {
//            int a, b, fib=0;
//            a = 0;
//            b = 1;
//            for (int i = 2; i <= term; i++) {
//                fib = a + b;
//                a=b;
//                b=fib;
//            }
//            return fib;
//        }
//    }
    public int fibo(int term) {
        if (term < 2) {
            return term;
        }
        return fibo(term - 1) + fibo(term - 2);
    }

    public void SolveHanoi(int n, char A, char B, char C) {//plates(3),first,middle,last
        if (n == 0) {
            return;
        }
        SolveHanoi(n - 1, A, C, B);
        System.out.println("move disk " + n + " from " + A + " to " + C + "");
        SolveHanoi(n - 1, B, A, C);
    }
}
