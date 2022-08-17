package Inheritance;

public class Bicycle extends Vehicle {

    int maxSpeed;
    String color;

    public void print(){
        // since in the parent class print() function is same so when we call the print function then it will first check in the
        // its main class if there is no print function then it will go to the parent class
        // But if we want to also access the parent class print function then we have to use super keyword to access it.
        super.print();  // It will print the parent class function
        System.out.println("Bicycle " + maxSpeed + " color " + getColor());
        super.maxSpeed = 120;
        super.setColor("Yellow");
        super.Vehicle_name = "Buggati";
        System.out.println("Bicycle " + super.maxSpeed + " color " + super.getColor() + " Vehicle name " + super.Vehicle_name);


    }

}
