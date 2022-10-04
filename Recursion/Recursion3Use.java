package Recursion;

import java.util.*;


public class Recursion3Use {
    public static void main(String[] args) {
        Recursion3 r3 = new Recursion3();

 /*       String[]  list = r3.subsequenceOfString("abc");
        for(int i=0; i< list.length; i++){
            System.out.print(list[i] +" ");
        }
*/

 /*       String[] ans = r3.keypad(24);
        for(String a : ans){
            System.out.print(a + " ");
        }
*/

/*
        int n = 6;
        r3.factorial2(n,1);
*/

    //    r3.printSubsequences("abc","");

    //    r3.printKeypad(27);

/*
        int[] input = {-9,4,-6,7};
        int[][] output = r3.subsetsSumK(input,-2);
        for(int[] o : output){
            for(int a : o){
                System.out.print(a + " ");
            }
            System.out.println();
        }
        r3.printSubsetsSumToK(input,-2);
*/



/*
        int[] input = {15,20,12};
      int[][] arr = r3.subsets(input);
      for(int[] a : arr){
          System.out.println(Arrays.toString(a));
      }
        r3.printSubsets(input);
*/

/*
        String str = "abc";
        String[] arr = r3.permutationOfString(str);
        for(String a : arr){
            System.out.println(a);
        }
*/

        r3.printPermutations("abc");

    }
}
