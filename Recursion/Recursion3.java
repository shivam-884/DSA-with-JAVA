package Recursion;

import java.util.*;

public class Recursion3 {

    private static String[] subsequenceStringHelper(String word){
        if(word.isEmpty()){
            String[] ans = new String[1];
            ans[0] = "";
            return ans;
        }
        String[] smallAns = subsequenceStringHelper(word.substring(1));
        String[] ans = new String[2* smallAns.length];
        for(int i=0; i<smallAns.length; i++){
            ans[i] = smallAns[i];
        }
        for(int i=smallAns.length; i<2*smallAns.length; i++){
            ans[i] = word.charAt(0) + smallAns[i-smallAns.length];
        }
        return ans;
    }

    public String[] subsequenceOfString(String word){
        String[] output = subsequenceStringHelper(word);
        return output;
    }

    private static String getOptions(int digit){

        if(digit == 2){
            return "abc";
        }
        if(digit == 3){
            return "def";
        }
        if(digit == 4){
            return "ghi";
        }
        if(digit == 5){
            return "jkl";
        }
        if(digit == 6){
            return "mno";
        }
        if(digit == 7){
            return "pqrs";
        }
        if(digit == 8){
            return "tuv";
        }
        if(digit == 9){
            return "wxyz";
        }
        return "";
    }

    public static String[] keypad(int n){
        if(n == 0 || n == 1){
            String[] smallAns = new String[1];
            smallAns[0] = "";
            return smallAns;
        }
        String[] smallAns = keypad(n/10);
        String temp = getOptions(n%10);
        String[] output = new String[smallAns.length*temp.length()];
        int k = 0, j=0;

        for(int i=0; i< output.length; i++){
            output[i] = smallAns[k] + temp.charAt(j);
            j++;
            if(j >= temp.length()){
                j = 0;
                k++;
            }
        }

        return output;
    }

    public static void factorial2(int input,int answer){
        if(input == 0){
            System.out.println(answer);
            return;
        }
        answer *= input;
        factorial2(input-1, answer);
    }

    public static void printSubsequences(String input, String stringSoFar){
        if(input.isEmpty()){
            System.out.println(stringSoFar);
            return;
        }
        printSubsequences(input.substring(1),stringSoFar);
        printSubsequences(input.substring(1),stringSoFar + input.charAt(0));
    }

    private static void printKeypadHelper(int n,String stringSoFar){
        if(n <= 1){
            System.out.println(stringSoFar);
            return;
        }
        String temp = getOptions(n%10);
        for(int i=0; i<temp.length(); i++){
            printKeypadHelper(n/10,temp.charAt(i)+stringSoFar);
        }
    }

    public static void printKeypad(int input){
        printKeypadHelper(input,"");
    }

/*    static void printAllSubsetsRec(int arr[], int n, List<Integer> v,int sum,List<List<Integer>> output)
    {
        if (sum == 0) {
            Collections.reverse(v);
            output.add(v);
            return;
        }
        if (n == 0)
            return;

        printAllSubsetsRec(arr, n - 1, v, sum,output);
        Vector<Integer> v1=new Vector<Integer>(v);
        v1.add(arr[n - 1]);
        printAllSubsetsRec(arr, n - 1, v1, sum - arr[n - 1],output);


    }
    static int[][] printAllSubsets(int arr[], int n, int sum)
    {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        printAllSubsetsRec(arr, n, v, sum,output);
        int[][] ans = output.stream().map(x -> x.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);

        return ans;
    }
    */

    public static int[][] subsetsSumKHelper(int[] input, int beginIndex, int k){
        if(beginIndex == input.length){
            if(k == 0){
                return new int[1][0];
            }else{
                return new int[0][0];
            }
        }
        int[][] smallOutput1 = subsetsSumKHelper(input,beginIndex+1,k);
        int[][] smallOutput2 = subsetsSumKHelper(input,beginIndex+1,k - input[beginIndex]);
        int[][] output = new int[smallOutput1.length + smallOutput2.length][];
        int index = 0;
        for(int i=0; i< smallOutput1.length; i++){
            output[index++] = smallOutput1[i];
        }
        for(int i=0; i< smallOutput2.length; i++){
            output[index] = new int[smallOutput2[i].length+1];
            output[index][0] = input[beginIndex];
            for(int j=0; j<smallOutput2[i].length; j++){
                output[index][j+1] = smallOutput2[i][j];
            }
            index++;
        }
        return output;
    }

    public static int[][] subsetsSumK(int input[],int k){
        return subsetsSumKHelper(input,0,k);
    }

    public static int[][] subsetsHelper(int input[], int n) {
        if(n == input.length){
            return new int[1][0];
        }
        int[][] smallOutput = subsetsHelper(input,n+1);
        int[][] output = new int[smallOutput.length*2][];
        int index = 0;
        for(int i=0; i<smallOutput.length; i++){
            output[index] = new int[smallOutput[i].length];

            for(int j=0; j< smallOutput[i].length; j++){
                output[index][j] = smallOutput[i][j];
            }
            index++;
        }

        for(int i=0; i<smallOutput.length; i++){
            output[index] = new int[smallOutput[i].length+1];
            output[index][0] = input[n];
            for(int j=1; j<= smallOutput[i].length; j++){
                output[index][j] = smallOutput[i][j-1];
            }
            index++;
        }
        return output;
    }
    public static int[][] subsets(int input[]) {
        return subsetsHelper(input,0);
    }

    public static String[] permutationOfString(String input){
        if(input.length() == 0){
            String output[] = {""};
            return output;
        }
        String[] smallerOutput = permutationOfString(input.substring(1));
        String output[] = new String[input.length()*smallerOutput.length];

        int index = 0;
        for(int i=0; i<smallerOutput.length; i++){
            String currentString = smallerOutput[i];
            for(int j=0; j<=currentString.length(); j++){
                output[index] = currentString.substring(0,j) + input.charAt(0)+ currentString.substring(j);
                index++;
            }
        }
        return output;
    }

    public static void printSubsetsHelper(int[] input,int beginIndex, int[] output){
        if(beginIndex == input.length){
            for(int i : output){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        int[] newOutput = new int[output.length+1];
        int i=0;
        for(; i<output.length; i++){
            newOutput[i] = output[i];
        }
        newOutput[i] = input[beginIndex];

        printSubsetsHelper(input, beginIndex+1, output);
        printSubsetsHelper(input, beginIndex+1, newOutput);
    }

    public static void printSubsets(int input[]){
        int[] output = new int[0];
        printSubsetsHelper(input,0,output);
    }

    public static void printSubsetsSumToKHelper(int[] input,int beginIndex, int[] output, int k){
        if(beginIndex == input.length){
            if(k==0){
                for(int i : output){
                    System.out.print(i+" ");
                }
                System.out.println();
                return;
            }else{
                return;
            }
        }
        int[] newOutput = new int[output.length+1];
        int i = 0;
        for(; i<output.length; i++){
            newOutput[i] = output[i];
        }
        newOutput[i] = input[beginIndex];
        printSubsetsSumToKHelper(input,beginIndex+1,output,k);
        printSubsetsSumToKHelper(input,beginIndex+1,newOutput,k-input[beginIndex]);
    }

    public static void printSubsetsSumToK(int[] input, int k){
        int[] output = new int[0];
        printSubsetsSumToKHelper(input,0, output, k);
    }

    public static void printPermutationsHelper(String input, String output){
        if(input.length() == 0){
            System.out.println(output);
            return;
        }
        for(int i=0; i<input.length(); i++){
            printPermutationsHelper((input.substring(0,i)+input.substring(i+1)), output+input.charAt(i));
        }
    }

    public static void printPermutations(String input){
        printPermutationsHelper(input,"");
    }

}
