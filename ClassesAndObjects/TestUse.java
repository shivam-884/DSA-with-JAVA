package ClassesAndObjects;

import java.util.Scanner;

public class TestUse {

    public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            int degree1[] = new int[n];
            for(int i = 0; i < n; i++){
                degree1[i] = s.nextInt();
            }
            int coeff1[] = new int[n];
            for(int i = 0; i < n; i++){
                coeff1[i] = s.nextInt();
            }
            Test first = new Test();
            for(int i = 0; i < n; i++){
                first.setCoefficient(degree1[i],coeff1[i]);
            }
            first.print();
            n = s.nextInt();
            int degree2[] = new int[n];
            for(int i = 0; i < n; i++){
                degree2[i] = s.nextInt();
            }
            int coeff2[] = new int[n];
            for(int i = 0; i < n; i++){
                coeff2[i] = s.nextInt();
            }
            Test second = new Test();
            for(int i = 0; i < n; i++){
                second.setCoefficient(degree2[i],coeff2[i]);
            }
            second.print();
            int choice = s.nextInt();
            Test result;
            switch(choice){
                // Add
                case 1:
                    result = first.add(second);
                    result.print();
                    break;
                // Subtract
                case 2 :
                    result = first.subtract(second);
                    result.print();
                    break;
               // Multiply
                case 3 :
                    result = first.multiply(second);
                    result.print();
                    break;
            }

        }


}
