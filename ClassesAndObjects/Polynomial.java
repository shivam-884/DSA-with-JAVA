package ClassesAndObjects;

public class Polynomial {
    private int data[];

    Polynomial(){
        data = new int[5];

    }

    public void setCoefficient(int deg, int cof){
        while(deg >= data.length){  // This means array is full, it has no space
            doubleCapacity(); // So now, We have to double the size of array
        }
        data[deg] = cof;
    }


    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2 * temp.length];
        for(int i = 0; i< temp.length; i++){
            data[i] = temp[i];
        }
    }

//    public void add(Polynomial p2){
//        for(int i = 0; i < data.length; i++){
//            this.data[i] += p2.data[i];
//        }
//    }

    public Polynomial add(Polynomial p){
        int temp;
        if(this.data.length > p.data.length){
            temp = this.data.length;
        } else {
            temp = p.data.length;
        }
        for(int i = 0; i < temp; i++){
            this.data[i] += p.data[i];
        }
        return this;
    }

    public void subtract(Polynomial p2){
        for(int i = 0; i < data.length; i++){
            this.data[i] -= p2.data[i];
        }
    }

    public void mul(Polynomial p1, Polynomial p2){

         for(int i = 0; i < p1.data.length; i++){
             for(int j = 0; j < p2.data.length; j++){
                int newDeg = i + j;
                 int newCof = p1.data[i] * p2.data[j];

                 while(newDeg >= this.data.length){  // This means array is full, it has no space
                    this.doubleCapacity(); // So now, We have to double the size of array
                 }
                 this.data[newDeg] += newCof;
             }
         }
    }

    public void print(){
        for(int i = 0; i < data.length; i++){
            if(data[i] != 0){
                if(data[i] < 0){
                    System.out.print("("+data[i]+")"+"x^"+i+"+");
                } else{
                System.out.print(data[i]+"x^"+i+"+");
            }
            }
        }
        System.out.println();
    }
}
