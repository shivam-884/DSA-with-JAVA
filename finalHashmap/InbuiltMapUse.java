package finalHashmap;

import java.util.HashMap;

public class InbuiltMapUse {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        // Insert
        map.put("abc", 1);
        map.put("def", 3);

        // Presence
        if(map.containsKey("abc")){
            System.out.println("map has abc");
        }
        if(map.containsKey("abc1")){
            System.out.println("map has abc1");
        }

        // Get Value
        int v = map.get("abc");
        System.out.println(v);
    }
}
