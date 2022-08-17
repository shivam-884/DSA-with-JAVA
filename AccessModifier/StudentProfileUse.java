package AccessModifier;

import java.util.Scanner;
import ClassesAndObjects.Student;

public class StudentProfileUse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StudentProfile s1 = new StudentProfile();
        StudentProfile s2 = new StudentProfile();
         s1.name = "Muskan";
      // s1.rollNumber = 235; // Since it has private access so it can't be access
         System.out.println(s1.name + " "); // + s1.rollNumber);

        s2.name = "Harsh";
       // s2.rollNumber = 238;
        System.out.println(s2.name + " " ); //+ s2.rollNumber);

    }
}
