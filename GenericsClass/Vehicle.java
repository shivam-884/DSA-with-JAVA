package GenericsClass;

public class Vehicle implements PrintInterface{
    int maxSpeed;
    String compony;

    public Vehicle(int maxSpeed, String compony){
        super();
        this.maxSpeed = maxSpeed;
        this.compony = compony;
    }

    public void print(){
        System.out.println(maxSpeed + " " + compony);
    }
}
