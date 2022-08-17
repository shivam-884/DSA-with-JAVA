package TimeComplexity;

public class Solution {

    public static void merge(int b[], int c[], int a[]){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < b.length && j < c.length){
            if(b[i] <= c[j]){
                a[k] = b[i];
                i++;
                k++;
            }else{
                a[k] = c[j];
                j++;
                k++;
            }
        }
        if(i < b.length){
            while(i < b.length){
                a[k] = b[i];
                i++;
                k++;
            }
        }

        if(j < c.length){
            while (j < c.length){
                a[k] = c[j];
                j++;
                k++;
            }
        }
    }


    public static void mergeSort(int a[]){
        if(a.length == 1){
            return;
        }

        int[] b = new int[a.length/2];
        int[] c = new int[a.length-b.length];

        for(int i=0; i<a.length/2; i++){
            b[i] = a[i];
        }

        for(int i=a.length/2; i<a.length; i++){
            c[i-(a.length/2)] = a[i];
        }

        mergeSort(b);
        mergeSort(c);
        merge(b,c,a);
    }



    public static int arrayEquilibriumIndex(int[] arr) {
        //Your code goes here
        int leftSum = 0, rightSum = 0;

        for(int i=0; i<arr.length; i++){
            rightSum += arr[i];
        }

        for(int i=0; i<arr.length; i++){
            rightSum -= arr[i];

            if(leftSum == rightSum){
                return i;
            }
               leftSum += arr[i];

        }
        return -1;
    }

    public static int findUnique(int arr[]){
        // xor of a number with itself is 0
        // xor of a number with 0 is number itself
        int xor = 0;
        for(int i=0; i<arr.length; i++){
            xor ^= arr[i];
        }
        return xor;
    }


    public static int findDuplicate(int[] arr) {
        // Sum of (n-2) number
        int sum = (arr.length-2) * (arr.length-1) / 2;
        int temp = 0;
        for(int i=0; i<arr.length; i++){
            temp += arr[i];
        }

        return temp - sum;
    }

    public static void reverseArr(int arr[], int si, int ei){

        while(si < ei){
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }
    }

    public static void rotate(int[] arr, int d) {


//        int[] a = new int[d];
//        for(int i=0; i<d; i++){
//            a[i] = arr[i];
//        }
//
//        int j=d;
//        while(j < arr.length){
//            arr[j-d] = arr[j];
//            j++;
//        }
//
//        for(int i=arr.length-d; i<arr.length; i++){
//            arr[i] = a[i - arr.length + d];
//
//        }


        // Reverse Approach
        reverseArr(arr, 0, arr.length-1);
        reverseArr(arr, 0, arr.length-d-1);
        reverseArr(arr, arr.length-d, arr.length-1);

    }

    public static int pairSum(int[] arr, int num) {
        //Your code goes here
        // Sort the array then apply this method
        if(arr.length == 0){
            return 0;
        }

        mergeSort(arr);
        int i=0, j=arr.length-1;
        int count = 0;
        while(i < j){
            if(arr[i] + arr[j] == num){
                int temp1 = arr[i];
                int c1 = 0;

                while(arr[i] == temp1 && i<j){
                    c1++;
                    i++;
                }

                count += c1;
                i -= c1;
                j--;
            } else if(arr[i] + arr[j] < num){
                i++;
            }else {
                j--;
            }
        }
        return count;
    }


    public static int tripletSum(int[] arr, int num) {
       if(arr.length == 0){
           return 0;
       }

       mergeSort(arr);
       int i=0;
       int count = 0;
       while(i < arr.length){
           int j=i+1, k = arr.length-1;
           while(j < k){
               if(arr[i] + arr[j] + arr[k] == num){
                   int temp1 = arr[j];
                   int c1 = 0;

                   while(arr[j] == temp1 && j<k){
                       c1++;
                       j++;
                   }

                   count += c1;
                   j -= c1;
                   k--;
               } else if(arr[i] + arr[j] + arr[k] < num){
                   j++;
               }else {
                   k--;
               }
           }
           i++;
       }
       return count;
    }


    public static void main(String[] args) {
//        int[] a = {1, -1, 4};
//        System.out.println(arrayEquilibriumIndex(a));

//        int[] b = {0, 0, 2, 3, 1, 6, 3, 6, 2};
//        System.out.println(findUnique(b));

//        int[] c = {0, 7, 2, 5, 4, 7, 1, 3, 6};
//        System.out.println(findDuplicate(c));

//        int[] d = {1, 2, 3, 4, 5, 6, 7};
//        rotate(d,2);
//        for(int i=0; i<d.length; i++){
//            System.out.print(d[i] + " ");
//        }

//        int[] e = {3, 3, 3, 3, 3};
//        System.out.println(pairSum(e,6));

        int[] f = {2, -5, 8, -6, 0, 5, 10, 11, -3};
        System.out.println(tripletSum(f, 10));
    }
}
