package arrayList;

import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(20);
        arr.add(30);
        arr.add(1, 89);

        // If we want to remove any element, suppose(10)
//        Integer i = 10;
//        arr.remove(i); // OR arr.remove(10);

        // If we want to just replace any index value
//        arr.set(0,100);

//        System.out.println(arr.size());
//        System.out.println(arr.get(1));


        // Printing the arrayList

//        for(int i=0; i<arr.size(); i++){
//            System.out.print(arr.get(i) + " ");
//        }

        // Enhanced loop
        for(int in : arr){
            System.out.print(in + " ");
        }


    }
}
