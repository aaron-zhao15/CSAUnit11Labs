package unit11;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import static java.lang.System.*;

class Rational implements Comparable<Rational> {
    //add two instance variables

    private int num;
    private int den;

    //write two constructors
    public Rational() {
        num = 1;
        den = 1;
    }

    public Rational(int n, int d) {
        num = n;
        den = d;
    }

    //write a setRational method
    public void setRational(int n, int d) {
        num = n;
        den = d;
    }

    //write  a set method for numerator and denominator
    public void setNumerator(int n) {
        num = n;
    }

    public void setDenominator(int d) {
        den = d;
    }

    public int getNumerator() {
        return num;
    }

    public int getDenominator() {
        return den;
    }

    public void add(Rational other) {
        //num1/den1 + num2/den2 
        //new numerator = (num1 * den2 + num2 * den1)
        //new denominator = (den1 * den2)
        this.num = (num * other.getDenominator() + other.getNumerator() * den);
        this.den = (den * other.getDenominator());
        reduce();
    }

    private void reduce() {
        int gcd = gcd(num, den);
        this.num = num / gcd;
        this.den = den / gcd;
    }

    private int gcd(int numOne, int numTwo) {
        int gcd = 1;
        for (int i = 1; i <= numOne && i <= numTwo; i++) {
            if (numOne % i == 0 && numTwo % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public Object clone() {
        return new Rational(num, den);
    }

    public boolean equals(Object obj) {
        boolean same = false;
        reduce();
        Rational temp = (Rational) obj;
        temp.reduce();
        if(this == obj || toString().equals(obj.toString()) ||
                num == temp.getNumerator() && den == temp.getDenominator()){ 
            same = true;
        }
        return same;
    }

    public int compareTo(Rational other) {
        reduce();
        other.reduce();
        return toString().compareTo(other.toString());
    }

    //write toString() method
    public String toString() {
        return num + "/" + den;
    }
}
