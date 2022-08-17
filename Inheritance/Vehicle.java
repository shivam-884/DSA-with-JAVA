package Inheritance;

public class Vehicle {

  private String color;
   protected int maxSpeed;
   public String Vehicle_name;

   public Vehicle(){
       System.out.println("Vehicle constructor");
   }




    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void print(){
        System.out.println("Vehicle " + "color " + color + " maxspeed " + maxSpeed);
    }
}
