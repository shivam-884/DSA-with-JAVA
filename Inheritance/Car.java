package Inheritance;

public class Car extends Vehicle{

    int numDoors;

    public Car(){
        System.out.println("Car's constructor");

    }


    public void print() {
        // When color is not private
        // System.out.println("Car " + "color " + color + " maxspeed " + maxSpeed + " numDoors " + numDoors);
         System.out.println("Car " + "color " + getColor() + " maxspeed " + maxSpeed + " numDoors " + numDoors);
    }
}
