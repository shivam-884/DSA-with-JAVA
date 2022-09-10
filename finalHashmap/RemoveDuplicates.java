package finalHashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class RemoveDuplicates {

    public static ArrayList<Integer> removeDuplicates(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int a : arr){
            if(map.containsKey(a)){
                 continue;
            }
            ans.add(a);
            map.put(a, true);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,2,3,1,6,2,5};
        ArrayList<Integer> output = removeDuplicates(arr);
        System.out.println(output);
    }
}
