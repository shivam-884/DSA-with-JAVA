package finalHashmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class PractiseHashmap {

    public static int maxFrequencyNumber(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        int key = -1;
        for(int a : arr){
            if(map.get(a) > max){
                max = map.get(a);
                key = a;
            }
        }
        return key;
    }

    public static void printIntersection(int[] arr1,int[] arr2){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int a : arr2){
            map.put(a, map.getOrDefault(a,0) + 1);
        }
        for(int a : arr1){
            if(map.containsKey(a)){
                System.out.println(a);
                if(map.get(a) > 1){
                    map.put(a, map.get(a)-1);
                }else{
                    map.remove(a);
                }
            }
        }
    }


    public static int pairSum(int[] input, int size) {
        HashMap<Integer,Integer> map = new HashMap<>();
       int countPair = 0;

       for(int a : input){
           if(map.isEmpty()){
               map.put(a,1);
               continue;
           }
           map.put(a,map.getOrDefault(a,0)+1);
           if(a == 0){
               countPair += map.get(a) - 1;
               continue;
           }
           if(map.containsKey(-1*a)){
               countPair += map.get(-1*a);
           }
       }
       return countPair;
    }

    public static String uniqueChar(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        String ans = "";
        for(int i=0; i<str.length(); i++){
            char k = str.charAt(i);
            if(map.size()==0){
                map.put(k,1);
                ans += k;
                continue;
            }
            if(!map.containsKey(k)){
                map.put(k,1);
                ans += k;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        for(int a : arr){
            map.put(a,i);
            i++;
        }

        int max_Length = 0;
        int start = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int a : arr){
            if(map.get(a) < 0){
                continue;
            }
            int index = map.get(a);
            int temp = a;
            int len = 0;
            while(map.containsKey(temp)){
                map.put(temp,-1);
                len++;
                temp++;
            }
            temp = a-1;
            while(map.containsKey(temp)){
                len++;
                index = map.get(temp);
                map.put(temp,-1);
                temp--;
            }
            int startC= temp + 1;
            map.put(startC,index);
            if(max_Length < len){
                max_Length = len;
                start = startC;
            }else if(max_Length == len){
                if(map.get(startC) < map.get(start)){
                    start = startC;
                }
            }
        }
        ans.add(start);
        ans.add(start+max_Length-1);
        return ans;
    }

    public static int getPairsWithDifferenceK(int arr[], int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int countPair = 0;
        for(int a : arr) {
            if(!map.containsKey(a)){
                continue;
            }

            if(map.containsKey(a+k) && k != 0){
                countPair += map.get(a) * map.get(a+k);
            }
            if(map.containsKey(a-k) && k != 0){
                countPair += map.get(a) * map.get(a-k);
            }
            if(k==0){
                countPair += map.get(a)-1;
                map.put(a,map.getOrDefault(a,1)-1);
            }
            map.remove(a);
        }
        return countPair;
    }

    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int max_Length = 0;
        int sum = 0;
        map.put(0,-1);
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                int length = i-map.get(sum);
                if(max_Length < length){
                    max_Length = length;
                }
                continue;
            }
            map.put(sum,i);
        }
        return max_Length;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
//        System.out.println(maxFrequencyNumber(arr));

        int[] arr1 = {0,0,0,0,0,0};
        int[] arr2 = {0,2,3,2,6,6,5,1};
//        printIntersection(arr1, arr2);

//        System.out.println(pairSum(arr1,6));

//        System.out.println(uniqueChar("codingninjas"));

/*        int[] input = {15,24,23,12,19,11,16};
//        3,7,2,1,9,8,41
//        2,12,9,16,10,5,3,20,25,11,1,8,6
        ArrayList<Integer> ans = longestConsecutiveIncreasingSequence(input);
        for(int a : ans){
            System.out.print(a + " ");
        }
    */

    /*    int[] input = {4,4,4,4};
        System.out.println(getPairsWithDifferenceK(input,0));
     */

        int[] input = {95, -97, -387, -435, -5, -70, 897, 127, 23, 284};
//        -1,2,8,-3,-5,2,-4,6,1,2,1,-3,4
        System.out.println(lengthOfLongestSubsetWithZeroSum(input));
    }
}
