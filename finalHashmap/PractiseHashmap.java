package finalHashmap;
import java.util.ArrayList;
import java.util.HashMap;

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

    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
//        System.out.println(maxFrequencyNumber(arr));

        int[] arr1 = {1,4,5,2,2,3,6,5,3,2};
        int[] arr2 = {0,2,3,2,6,6,5,1};
        printIntersection(arr1, arr2);
    }
}
