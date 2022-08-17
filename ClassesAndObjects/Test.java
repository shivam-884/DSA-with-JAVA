package ClassesAndObjects;

import java.util.Arrays;

public class Test{

         int data[];

        Test(){
                data = new int[5];
        }

        // Copy Constructor
       public Test(Test t){
                data = new int[t.data.length];
               for(int i = 0; i < t.data.length; i++){
                       this.data[i] = t.data[i];
               }
        }
        /* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
         *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
         *  is already present in the polynomial then previous coefficient is replaced by
         *  new coefficient value passed as function argument
         */
        public void setCoefficient(int degree, int coeff){
                while(degree >= data.length){
                        doublecapcity();
                }
                data[degree] = coeff;
        }

        public void doublecapcity(){
                int temp[] = data;
                data = new int[2 * temp.length];
                for(int i = 0; i < temp.length; i++){
                        data[i] = temp[i];
                }
        }

        // Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree.
        public void print(){
                for(int i = 0; i < data.length; i++){
                        if(data[i] != 0) {
                                System.out.print(data[i] + "x" + i + " ");
                        }
                }
        }


        // Adds two polynomials and returns a new polynomial which has result
        public Test add(Test p){
            int temp;
           Test t1;
                if(data.length >= p.data.length){
                 t1 = new Test(this);
                temp = p.data.length;
                for(int i = 0; i < temp; i++){
                    t1.data[i] += p.data[i];
                }
                } else {
                    t1 = new Test(p);
                    temp = data.length;
                    for(int i = 0; i < temp; i++){
                        t1.data[i] += data[i];
                    }
                }
                return t1;
        }

        //Subtracts two polynomials and returns a new polynomial which has result
        public Test subtract(Test p){
            int temp;
            Test t1;
            if(data.length >= p.data.length){
                t1 = new Test(this);
                temp = p.data.length;
                for(int i = 0; i < temp; i++){
                    t1.data[i] -= p.data[i];
                }
            } else {
                t1 = new Test(p);
                temp = data.length;
                for(int i = 0; i < temp; i++){
                    t1.data[i] -= data[i];
                }
            }
            return t1;
        }

         //Multiply two polynomials and returns a new polynomial which has result
        public Test multiply(Test p){
          Test t1 = new Test();
          int[] temp = new int[data.length + p.data.length];
          t1.data = temp;
            for(int i = 0; i < data.length; i++){
                for(int j = 0; j < p.data.length; j++){
                    t1.data[i + j] += data[i] * p.data[j];

                }
            }
            return t1;

    }

}