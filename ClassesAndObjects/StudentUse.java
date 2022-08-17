package ClassesAndObjects;

import java.util.Scanner;

public class StudentUse {

    public static void hello(){
        System.out.println("HEllo Peter");
    }
    public static void main(String[] args) {
       // Scanner s = new Scanner(System.in);
     //   Student s1 = new Student();
      //  Student s2 = new Student();
   //     System.out.println("s1 " + s1);  // This will display the location of object where it is stored
  //      s1.name = "Shivam";
//        s1.rollNumber = 240;
//        System.out.println(s1.name + " " + s1.rollNumber);

 //        s2.name = "Harsh";
//        s2.rollNumber = 238;
//        System.out.println(s2.name + " " + s2.rollNumber);


        // Using Getters and Setters

//        s1.setRollNumber(231);
//        System.out.print(s1.name+" ");
//        System.out.println(s1.getRollNumber());  // We can access the private instance variable using Setter and Getter method
//
//        System.out.println("s2 "+s2);
//        s2.setRollNumber(234);
//        System.out.print(s2.name+" ");
//        System.out.println(s2.getRollNumber());

        // Using the constructor and printing the details of student

        Student s1 = new Student("Shivam", 240);
        Student s2 = new Student("Harsh");
        Student s3 = new Student("Mukesh");

        s1.print();
        s2.print();

        System.out.println(Student.getNumStudent());
        hello();


    }
}
