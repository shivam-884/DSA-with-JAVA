package ExceptionHandling;

public class ExceptionDemo {

    public static int fact(int n) throws NegativeNumberException {
        if(n < 0){
            throw new NegativeNumberException();
        }
        int ans = 1;
        for(int i = 2; i <= n; i++){
            ans = ans * i;
        }
        return ans;
    }

    public static int divide(int a, int b) throws DivideByZeroException{
        if(b == 0){
//            throw new ArithmeticException();
            throw new DivideByZeroException();
        }
        return a/b;
    }

    public static void main(String args[]){

//        String s = null;
//        System.out.println(s.length());
//        System.out.println(4/0);

        // If we want to handle the error then we have to use try-catch block
        try{
            divide(10, 0);
            System.out.println(fact(3));
            System.out.println("Within Try");
        } catch (DivideByZeroException e){
            System.out.println("Divide by zero exception");
        } catch (NegativeNumberException e) {
            System.out.println("Negative Number Exception ");
        }catch (Exception e){
            System.out.println("Generic Exception");
        }finally {
            // Finally, block wil be executed whether error is occurred or not in try block
            System.out.println("Finally");
        }
        System.out.println("Main");
    }
}
