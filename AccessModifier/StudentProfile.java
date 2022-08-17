package AccessModifier;

public class StudentProfile {
    String name;
    private int rollNumber;

    public static void main(String[] args) {
        StudentProfile s = new StudentProfile();
        s.name = "Gullu";
        s.rollNumber = 233;

        System.out.println(s.name + " " + s.rollNumber);
    }
}
