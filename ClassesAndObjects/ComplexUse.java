package ClassesAndObjects;

public class ComplexUse {
    public static void main(String args[]){
        Complex c1 = new Complex(3,5);
        c1.print();

        Complex c2 = new Complex(4,-5);
        c2.print();

        // Addition of two complex num
        c1.add(c2);
        c1.print();

        // Subtraction of two complex num
//        c1.sub(c2);
//        c1.print();

        // Multiplication of two complex num
//        c1.mul(c2);
//        c1.print();

        // Division of two complex num
//        c1.div(c2);
//        c1.print();
    }
}
