package Recursion;

public class Recursion2 {

    public static String replaceChar(String s, char a, char b){
        if(s.length() == 0){
            return s;
        }

        String smallOutput = replaceChar(s.substring(1), a, b);
        if(s.charAt(0) == a){
            return b + smallOutput;
        }else{
            return s.charAt(0) + smallOutput;
        }
    }

    public static String replacePi(String s){
        if(s.length() <= 1){
            return s;
        }
        if(s.charAt(0) == 'p' && s.charAt(1) == 'i'){
            // call recursion on string of length n-2
            String smallOutput = replacePi(s.substring(2));
            return "3.14" + smallOutput;
        }else {
            // call recursion on string of length n-1
            String smallOuptut = replacePi(s.substring(1));
            return s.charAt(0) + smallOuptut;
        }
    }

    public static String removeConsecutiveDuplicates(String s) {
        // Write your code here
        if(s.length() <= 1){
            return s;
        }

        String smallOutput = removeConsecutiveDuplicates(s.substring(1));
        if(s.charAt(0) == smallOutput.charAt(0)){
            return s.charAt(0) + smallOutput.substring(1);
        }else{
            return s.charAt(0) + smallOutput;
        }
    }

    public static int binarySearch(int a[], int si, int ei, int x){
        if(si > ei){
            return -1;
        }
        int midIndex = (ei + si)/2;
        if(a[midIndex] == x){
           return midIndex;
        }else if(a[midIndex] > x){
           return binarySearch(a, si, midIndex-1, x);
        }else{
            return binarySearch(a,midIndex+1, ei, x);
        }
    }

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


    public static void printArr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void intersection(int[] arr1, int[] arr2) {
        //Your code goes here
        mergeSort(arr1);
        mergeSort(arr2);
        printArr(arr1);
        printArr(arr2);

        int i = 0;
        int j = 0;


        while(i<arr1.length && j<arr2.length){
            if(arr1[i] == arr2[j]){
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }else if(arr1[i] < arr2[j]){
                i++;
            }else{
                j++;
            }
        }


//        // second approach
//        if(arr1.length <= arr2.length) {
//            mergeSort(arr1);
//            for (int k : arr2) {
//                binarySearch(arr1, 0, arr1.length - 1, k);
//            }
//        }else{
//            mergeSort(arr2);
//                for (int j : arr1) {
//                    binarySearch(arr2, 0, arr2.length - 1, j);
//                }
//        }



    }



    public static int partition(int a[], int si, int ei){
       int pivotElement = a[si];
       int smallNumberCount = 0;
       for(int i=si+1; i<=ei; i++){
           if(pivotElement > a[i]){
               smallNumberCount++;
           }
       }

       int temp = a[si+smallNumberCount];
       a[si+smallNumberCount] = pivotElement;
       a[si] = temp;

       int i = si;
       int j = ei;
       while(i<j){
           if(a[i] < pivotElement){
               i++;
           }else if(a[j] >= pivotElement){
               j--;
           }else{
               temp = a[j];
               a[j] = a[i];
               a[i] = temp;
               i++;
               j--;
           }
       }
       return si + smallNumberCount;

    }

    public static void quickSort(int a[], int si, int ei){
        if(si >= ei){
            return;
        }
        int pivotIndex = partition(a, si, ei);
        quickSort(a, si, pivotIndex-1);
        quickSort(a,pivotIndex+1, ei);

    }


    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        // Write your code here
        if(n == 1){
            System.out.println("Move the 1st disk from " + source + " " + destination);
            return;
        }
        towerOfHanoi(n-1, source, destination,auxiliary);
        System.out.println("Move the " + n + "th disk from " + source + " " + destination);
        towerOfHanoi(n-1, auxiliary, source, destination);
    }

    public static double findGeometricSum(int k){

        if(k == 0){
            return 1;
        }

        double smallOutput = findGeometricSum(k-1);
        double output = 1/Math.pow(2,k) + smallOutput;

        return output;

        }


    public static String checkStringPalindrome(String s){
        if(s.length() == 1){
            return s;
        }

        String smallOutput = checkStringPalindrome(s.substring(1));
        String output = smallOutput + s.charAt(0);
        return output;
    }

    public static boolean isStringPalindrome(String input) {
        // Write your code here
        if(input.length() <= 1){
            return true;
        }
        String ans = checkStringPalindrome(input);
        if(ans.equals(input)){
            return true;
        }else {
            return false;
        }
    }


    public static int convertStringToInt(String input){
        // Write your code here
        if(input.length() == 1){
            int b = input.charAt(0) - 48;
            return b;
        }

        int smallOutput = convertStringToInt(input.substring(1));
        int c = input.charAt(0) - 48;
        int  output = c * (int) Math.pow(10,input.length()-1) + smallOutput;
        return output;

    }

    public static String addStars(String s) {
        // Write your code here
        if(s.length() <= 1){
            return s;
        }
        String smallOutput = addStars(s.substring(1));
        if(s.charAt(0) == s.charAt(1)){
            return s.charAt(0) + "*" + smallOutput;
        }else{
            return s.charAt(0) + smallOutput;
        }
    }

    public static boolean checkAB(String input) {
        // Write your code here
        if(input.length() == 0){
            return true;
        }

        if(input.charAt(0) == 'a'){
            if(input.substring(1).length() > 1 && input.substring(1,3).equals("bb")){
                return checkAB(input.substring(3));
            }else{
                return checkAB(input.substring(1));
            }
        }
        return false;
    }


    public static int staircase(int n){
        if(n < 0){
            return 0;
        }
        if(n == 1 || n == 0){
            return 1;
        }
        int smallOutput = staircase(n-1) + staircase(n-2) + staircase(n-3);
        return smallOutput;
    }

    public static void func(int n)
    {
        int sum=0;
        for(int i=1;i<n;i++)
        {
            for(;i<n*n;i++)
            {
                sum+=i;
            }
        }
        System.out.println(sum);
    }

    public static int sum(int arr[]){
        int temp = 0;
        for(int i=1; i<arr.length; i++){
            temp += arr[i];
        }
        return temp;
    }

    public static int arrayEquilibriumIndex(int[] arr) {
        //Your code goes here
        if (arr.length == 1) {
            return 0;
        }
        int rightSum = sum(arr);
        int leftSum = 0;
        int count = 0;
        int j = 0;
        while (j < arr.length) {
            if(leftSum == rightSum){
                count = j;
            }

            if(j != arr.length-1){
                rightSum -= arr[j+1];
                leftSum += arr[j];
            }
            j++;
        }
if(count == 0){
    return -1;
}else {
    return count;
}
    }


    public static int findUnique(int[] arr) {
        //Your code goes here
        mergeSort(arr);

        int j = 1;
        while (j < arr.length){
            if(arr[j-1] == arr[j]){
                j += 2;
                continue;
            }else{
                return arr[j-1];
            }
        }
        return arr[arr.length-1];
    }


    public static void main(String[] args) {
//        System.out.println(replaceChar("abcxdxex", 'x', 'y'));
//       System.out.println(replacePi("apibpi"));
//        System.out.println(removeConsecutiveDuplicates("CCooddiinnggNNiinnnnjjjjaaaassss"));
//        int[] a = {2,3,5,6,7,8,9,11};
//        System.out.println(binarySearch(a,0, a.length-1,7));
        int[] a = {2,3,4,1,7,6,32,22,11};
//        mergeSort(a);
//        for(int i=0; i<a.length; i++){
//            System.out.print(a[i] + " ");

//        quickSort(a, 0, a.length-1);
//        for(int i=0; i<a.length; i++){
//            System.out.print(a[i] + " ");}

//        towerOfHanoi(4,'a', 'b', 'c');
//        System.out.println(findGeometricSum(10));
//        System.out.println(isStringPalindrome("abba"));
//        System.out.println(convertStringToInt("000120034000"));
//        System.out.println(addStars("haabello"));
//        System.out.println(staircase(5));
//        System.out.println(checkAB("aa"));
//        func(3);
//        int[] b = {3,12, 9, 7, 6, 22,34};
//        intersection(a,b);

//        int[] c = {1, -1, 4};
//        System.out.println(arrayEquilibriumIndex(c));

        int[] d = {2,3,4,5,2,1,3,4,5};
        System.out.println(findUnique(d));
    }
}
