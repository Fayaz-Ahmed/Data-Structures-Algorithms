/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adtfractionapp;

/**
 *
 * @author fatech98
 */
public class ADTFractionApp {

    public static void main(String[] args) {
        // TODO code application logic here
        ADTFraction f1 = new ADTFraction(3, 5);
        f1.display();
        ADTFraction f2 = new ADTFraction(7, 8);
        f2.display();
        ADTFraction f3 = f1.plus(f2);
        f3.display();
        ADTFraction f4 = f1.times(f2);
        f4.display();
        ADTFraction f5 = f1.times(2);
        f5.display();

    }

}

class ADTFraction {

    private int n; //numerator
    private int d; //denomenator //---------------------------------------------------

    public ADTFraction() {//default constructor
        this.n = 0;
        this.d = 1;
    }
//---------------------------------------------------

    public ADTFraction(int a, int b) {//parameter constructor   denomenator can not be 0 so before we assign value for b we will check whether b is not 0
        if (b != 0) {
            this.d = b;
            this.n = a;
        } else {
            this.n = 0;
            this.d = 1;
            System.out.println("denomenator can not be zero, so default values assigned");
        }
    }
//---------------------------------------------------

    public void set(int a, int b) {//set numerator and denomenator
        if (b != 0) {
            this.d = b;
            this.n = a;
        } else {
            this.n = 0;
            this.d = 1;
            System.out.println("denomenator can not be zero, so default values assigned");
        }
    }
//---------------------------------------------------

    public ADTFraction plus(ADTFraction x) {//add two fractions   this=3/5, x=7/8
        int num, den;
        den = this.d * x.d;
        num = x.d * this.n + this.d * x.n;
        ADTFraction f1 = new ADTFraction(num, den);// return new ADTFraction(num,den);
        return f1;
    }
//---------------------------------------------------

    public ADTFraction times(int a) {//multiply fraction by a number  times multiply
        int num, den;
        den = this.d;
        num = this.n * a;
        ADTFraction f1 = new ADTFraction(num, den);
        return f1;
    }
//---------------------------------------------------

    public ADTFraction times(ADTFraction x) {//multiply two fractions
        int num, den;
        num = this.n * x.n;
        den = this.d * x.d;
        ADTFraction f3 = new ADTFraction(num, den);
        return f3;
    }
//---------------------------------------------------

    public ADTFraction reciprocal() {//reciprocal of a fraction this 3/5, reciprocal = 5/3
        ADTFraction f1 = new ADTFraction(this.d, this.n);
        return f1;
    }
//---------------------------------------------------

    public float value() {//numerical value of a fraction this = 3/5;
        return (float) this.n / this.d;
    }
//---------------------------------------------------

    public void display() {//display the fraction in the format n/d
        System.out.println("Fraction =" + this.n + "/" + this.d);
    }
//---------------------------------------------------
}
