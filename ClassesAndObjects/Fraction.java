package ClassesAndObjects;

public class Fraction {
    int numerator;
    int denominator;

    public Fraction(int numerator, int denominator){
        if(denominator == 0){
            denominator = 1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public void setNumerator(int numerator){
        this.numerator = numerator;
        simplify();
    }

    public int getNumerator(){
        return numerator;
    }

    public void setDenominator(int denominator){
        if(denominator == 0){
            return;
        }
        this.denominator = denominator;
        simplify();
    }

    public int getDenominator(){
        return denominator;
    }

    private void simplify() {
        int gcd = 1;
        int smaller = Math.min(numerator, denominator);
        for (int i = 2; i <= smaller; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    public void print(){

        System.out.println(numerator + "/" + denominator);
    }

    public void increment(){
        numerator = numerator + denominator;
        simplify();
    }

    public void add(Fraction f2){    // f1 = f1 + f2;
        // First fraction is fraction on which the function is called
        // Second fraction is passed as arguments
        this.numerator = this.numerator * f2.denominator + f2.numerator * this.denominator;
        this.denominator = this.denominator * f2.denominator;
        simplify();
    }
    // Fraction f3 <-- add(f1,f2)
    public static Fraction add(Fraction f1, Fraction f2){
        int newNum = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        int newDen = f1.denominator * f2.denominator;
        Fraction f3 = new Fraction(newNum, newDen);
        return f3;
    }

    // Multiplication of fraction
    public void mul(Fraction f2){
        this.numerator *= f2.numerator;
        this.denominator *= f2.denominator;
        simplify();
    }

    // Substraction of two fraction
        // f1 = f1 - f2;
     public void sub(Fraction f2){
         this.numerator = this.numerator * f2.denominator - f2.numerator * this.denominator;
         this.denominator = this.denominator * f2.denominator;
        simplify();
     }

     // Division of fraction
    public void div(Fraction f2){
        this.numerator *= f2.denominator;
        this.denominator *= f2.numerator;
        simplify();
    }

}
