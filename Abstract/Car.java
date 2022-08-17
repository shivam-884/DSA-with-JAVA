package Abstract;

public abstract class Car extends Vehicle{
    int numDoors;
    int numGears;

    public Car(){
        super(100);
        System.out.println("Car's constructor");
        numDoors = 4;
        numGears = 5;
    }

    public Car(int numDoors, int maxSpeed){
        super(maxSpeed);
        System.out.println("Car's Constructor");
        this.numDoors = numDoors;
    }


    public void print() {
        System.out.println("Car numDoors "+ numDoors + " numGears " +numGears);
    }

    @Override
    public boolean isMotorized() {
        return true ;
    }

}
