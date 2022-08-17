package Inteface;

public interface VehicleInterface {

    double PI = 3.14;

    // In interface, all the method are by default abstract and public, So there is no
    // need to use keywords abstract and public for declare any method
    boolean isMotorized();

     String getCompony();

     int numGears();

   public void print();
}
