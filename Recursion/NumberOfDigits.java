package Recursion;

public class NumberOfDigits {

    public static int count(int n){
        if(n/10 == 0){
            return 1;
        }

        int smallOutput = count(n/10);
        int output = 1 + smallOutput;
        return output;
    }

    public static int reverse(int num){
        if(num/10 == 0){
            return num;
        }
       int rn = reverse(num/10);
        int cnt = count(num);
        return (int) ((Math.pow(10, cnt-1))*(num%10) + rn);
    }

    public static void main(String[] args) {

        System.out.println(count(1204));
        System.out.println(reverse(20001));
    }
}
