package ClassesAndObjects;

public class PolynomialUse {

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.setCoefficient(2,3);
        p1.setCoefficient(1,2);
       // p1.setCoefficient(2,5);
        p1.print();

        Polynomial p2 = new Polynomial();
        p2.setCoefficient(3,5);
        p2.setCoefficient(2,4);
        p2.setCoefficient(0,3);
        p2.print();

        Polynomial res;
        res = p1.add(p2);
        res.print();

        // Addition of p1 and p2
//        p1.add(p2);
//        p1.print();

        // Subtraction of p1 and p2
//        p1.subtract(p2);
//        p1.print();

        // Multiplication of p1 and p2
//       Polynomial p3 = new Polynomial();
//       p3.mul(p1,p2);
//        p3.print();
    }
}
