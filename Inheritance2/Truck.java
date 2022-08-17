package Inheritance2;

import Inheritance.Vehicle;
//
public class Truck extends Vehicle{

    int maxLoadingCapacity;

    public void print(){
        System.out.println("Vehicle " + "color " + getColor() + " maxspeed " + maxSpeed + " maxLoadingCapacity " + maxLoadingCapacity);
    }

}
