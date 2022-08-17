package ClassesAndObjects;

public class Student {
    String name;
   private int rollNumber;
private static int numStudents;

   // Constructor

//    We can create default constructor also and can perform some task
//    public Student(){
//      // Here we can set the default value of name and rollNumber also
//          name = "abc";
//          rollNumber = 2311;
//    }

      // We can pass argument also in the constrctor
    public Student(String n, int num){
        name = n;
        rollNumber = num;
        numStudents++;
    }

    public Student(String n){

        name = n;
        numStudents++;
    }


   public int getRollNumber(){
       return rollNumber;
   }

//   public void setRollNumber(int num){
//       rollNumber = num;
//   }

    // Use of this keyword
    public void setRollNumber(int rollNumber, double cf){   // since here rollNumber is local variable
      //  System.out.println("this "+ this);  // Here if we are calling it with the s1 object then it will refer the s1 and print same output as s1, similarly for s2
       this.rollNumber = rollNumber;  // here also both variable are local and we are unable to set the value of instance variable

    }

    // Print the details
    public void print(){
        System.out.println(name + " " + rollNumber);
    }

    // Getter method to get numStudents
    public static int getNumStudent(){
        return numStudents;
    }


}
