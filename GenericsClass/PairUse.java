package GenericsClass;

import Inheritance.Vehicle;

public class PairUse {
    public static void main(String[] args) {


//
//        Pair<String> p = new Pair<>();
//        p.setFirst("HEllo John");
//        System.out.println(p.getFirst() + " " + p.getSecond());
//
//
//          Pair p = new Pair(10, 20);
//          p.setFirst("aa");
//          p.setFirst(10);
//        System.out.println(p.getFirst() + " " + p.getSecond());
//
////        PairString ps = new PairString("aa", "bb");
////        PairDouble pd = new PairDouble(3.1, 7,2);
//
//        Pair<String> pS = new Pair<String>("aa", "bb");
//        System.out.println(pS.getFirst() + " " + pS.getSecond());
//        pS.setFirst("Pappu");
//
//        Pair<Integer> pI = new Pair<Integer>(10, 20);
//        System.out.println(pI.getFirst() + " " + pI.getSecond());
//
//        Pair<Double> pD = new Pair<>(10.6, 20.8);
//        System.out.println(pD.getFirst() + " " + pD.getSecond());

//        Pair<Vehicle> pV = new Pair<Vehicle>(new Vehicle(), new Vehicle());


        // CREATING MULTIPLE GENERICS CLASS

//        Pair<String, Integer> pSI = new Pair<String, Integer>("ab", 10);
//        System.out.println(pSI.getFirst() + " " + pSI.getSecond());


        // CHAINED GENERICS PAIRS

        Pair<String, Integer> pInner = new Pair<String, Integer>("ab", 100);
        Pair<Pair<String, Integer>, String> p = new Pair<>();
        p.setFirst(pInner);
        System.out.println(p.getFirst());
        System.out.println(p.getFirst().getFirst());
        System.out.println(p.getFirst().getSecond());

//        p.setSecond("abcd");
//        System.out.println(p.getSecond());

    }
}
