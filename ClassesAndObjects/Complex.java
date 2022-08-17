package ClassesAndObjects;

public class Complex {
    int real;
    int img;

    public Complex(int real, int img){
        this.real = real;
        this.img = img;
    }

    public void add(Complex c2){
        this.real = this.real + c2.real;
        this.img = this.img + c2.img;
    }

    public void print(){
        if(img < 0){
            int temp = -1 * img;
            System.out.println(real + "-" + temp + "i");
        }else{
        System.out.println(real + "+" + img + "i");
        }
    }
}


//    public void sub(Complex c2){
//        this.real -= c2.real;
//        this.img -= c2.img;
//    }
//
//    public void mul(Complex c2){
//        int c1real = this.real;
//        this.real = (this.real * c2.real) - (this.img * c2.img);
//        this.img = (this.img * c2.real) + (c1real * c2.img);
//    }
//
//    public void div(Complex c2){
//        int a1 = (this.real * c2.real) + (this.img * c2.img);
//        int a2 = (this.img * c2.real) - (this.real * c2.img);
//        int a3 = c2.real*c2.real + c2.img*c2.img;
//        this.real = a1/a3;
//        this.img = a2/a3;
//    }