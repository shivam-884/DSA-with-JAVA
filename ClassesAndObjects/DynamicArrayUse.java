package ClassesAndObjects;


import java.util.ArrayList;

public class DynamicArrayUse {

    public static void main(String[] args) {
        DynamicArray d = new DynamicArray();

        for (int i = 1; i < 100; i++) {
            d.add(100 + i);    // add(12) function is used to insert the element(12) in the dynamic array
        }

        System.out.println(d.size());  // size() function is used to check the size of dynamic array
        System.out.println(d.get(2));  // get(i) function will display the element at the index(i)
        d.set(3, 170);  // set(i, e) function will insert the element(e) at the index(i) and override the previous element
        System.out.println(d.get(3));

        while (!d.isEmpty()) {   // isEmpty() is used to check that the dynamic array is empty or not, its return boolean value
            System.out.println(d.removeLast());  // removeLast() function will remove last element from the dynamic array
            System.out.println("size - " + d.size());
        }
    }
}


