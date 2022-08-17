package Recursion;

public class Recursion {

    public static int fact(int n){
        if(n == 0){
            return 1;
        }
        int smallOutput = fact(n-1);
        int output = n * smallOutput;
        return output;
    }

    public static int sumn(int n){
        if (n == 0){
            return 0;
        }

        int smallOutput = sumn(n-1);
        int output = n + smallOutput;
        return output;
    }

    public static void print1ton(int n){
        if(n == 0){
            return;
        }
        print1ton(n-1);
        System.out.print(n + " ");
    }

    public static int fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        int fib_n_1 = fib(n-1);
        int fib_n_2 = fib(n-2);
        int output = fib_n_1 + fib_n_2;
        return output;
    }

    public static boolean isSorted(int a[]){
        if(a.length == 1){
            return true;
        }
        if(a[0] > a[1]){
            return false;
        }
        int smallArray[] = new int[a.length - 1];
        for(int i = 1; i < a.length; i++){
            smallArray[i-1] = a[i];
        }
        boolean isSmallArraySorted = isSorted(smallArray);
        return isSmallArraySorted;
    }

    public static int sum(int input[]) {

        if(input.length == 1){
            return input[0];
        }

        int[] smallArray = new int[input.length-1];
        for(int i = 1; i<input.length; i++){
            smallArray[i-1] = input[i];
        }
        int totalSum = input[0] + sum(smallArray);
        return totalSum;
    }

    public static boolean checkNumber(int input[], int x) {
        if(input.length == 1){
            if(input[0] == x){
                return true;
            }else {
                return false;
            }
        }

        if(input[0] == x){
            return true;
        }

        int[] smallArray = new int[input.length-1];
        for(int i=1; i<input.length; i++){
            smallArray[i-1] = input[i];
        }
        boolean isXFound = checkNumber(smallArray, x);
        return isXFound;
        }

        public static boolean isSortedBetter(int a[], int si){
         if(si == a.length-1){
             return true;
         }
         if(a[si] > a[si + 1]){
             return false;
         }
         boolean isSmallArraySorted = isSortedBetter(a, si + 1);
         return isSmallArraySorted;
        }


        public static int firstIndex(int a[], int x, int si){
        if(a.length == 0){
            return -1;
        }
        if(a[si] == x){
            return si;
        }
        if(a.length-1 == si){
            return -1;
        }
//        for using this copy method remove start index
//        int[] smallArray = new int[a.length-1];
//        for(int i=1; i<a.length; i++){
//            smallArray[i-1] = a[i];
//        }
//            int fi = firstIndex(smallArray,x);
//        if(fi == -1){
//            return -1;
//        } else {
//            return fi + 1;
//        }

        int fi = firstIndex(a, x, si+1);
        return fi;
        }

        public static int lastIndex(int a[], int x, int si) {
//        if(a.length == 0){
//            return -1;
//        }
//        int[] smallArray = new int[a.length-1];
//        for(int i=1; i<a.length; i++){
//            smallArray[i-1] = a[i];
//        }
//        int k = lastIndex(smallArray,x);
//        if(k != -1){
//            return k+1;
//        }else {
//            if(a[0] == x){
//                return 0;
//            }else {
//                return -1;
//            }
//        }
//
            if (si == a.length) {
                return -1;
            }
            int k = lastIndex(a, x, si + 1);
            if (k != -1) {
                return k;
            } else {
                if (a[si] == x) {
                    return si;
                } else {
                    return -1;
                }

            }
        }



    public static void main(String args[]){
//        System.out.println(fact(5));
//        System.out.println(sumn(11));
//        print1ton(7);
//       System.out.println(fib(5));
        int[] a = {1,2,1};
//        System.out.println(isSorted(a));
//        System.out.println(sum(a));
//        System.out.println(checkNumber(a,2));
//        System.out.println(isSortedBetter(a,0));
//        System.out.println(firstIndex(a,4, 0));
        System.out.println(lastIndex(a, 1, 0));
    }
}
