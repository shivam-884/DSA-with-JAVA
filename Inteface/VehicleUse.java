package Inteface;

public class VehicleUse {
    public static void main(String[] args) {

        Vehicle v = new Vehicle();

        // We can't create an instance of interface
        VehicleInterface vI;

        vI = new Car();
//        vI.getCompony();
//        vI.numGears();
        System.out.println(vI.getCompony());
        System.out.println(vI.numGears());
        vI.print();
    }
}
