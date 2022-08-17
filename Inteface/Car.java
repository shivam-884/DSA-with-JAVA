package Inteface;

// When we are inheriting the parent class then we use "extends" keyword but
// In case of interface we use "implements" keyword to implement the interface
public class Car extends Vehicle implements VehicleInterface{


    @Override
    public boolean isMotorized() {
        return true;
    }

    @Override
    public String getCompony() {
        return null;
    }

    @Override
    public int numGears() {
        return 5;
    }

  public void print(){
        System.out.println("CAR Class");
    }
}
