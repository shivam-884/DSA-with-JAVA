package Recursion;

import java.util.*;

public class Recursion3Use {
    private static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        Recursion3 r3 = new Recursion3();

    /*    String[]  list = r3.subsequenceOfString("abc");
        for(int i=0; i< list.length; i++){
            System.out.print(list[i] +" ");
        }
     */

    /*    String[] ans = r3.keypad(24);
        for(String a : ans){
            System.out.print(a + " ");
        }
    */

    /*    int n = 6;
        r3.factorial2(n,1);
     */

    //    r3.printSubsequences("abc","");

    //    r3.printKeypad(27);

        int[] input = {-9,4,-6,7};
        int[][] output = r3.subsetsSumK(input,-2);
        for(int[] o : output){
            for(int a : o){
                System.out.print(a + " ");
            }
            System.out.println();
        }

    /*  int[] input = {15,20,12};
      int[][] arr = r3.subsets(input);
      for(int[] a : arr){
          System.out.println(Arrays.toString(a));
      }
    */

        String str = "abc";
        int n = str.length();
        permute(str, 0, n-1);

    }
}
