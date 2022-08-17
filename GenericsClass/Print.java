package GenericsClass;

import java.net.InetSocketAddress;

public class Print {

    public static<T extends PrintInterface> void printArray(T arr[]){
        for(int i=0; i<arr.length; i++){
            arr[i].print();
//            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
//        Integer[] arr = new Integer[5];
//        for(int i=0; i<arr.length; i++){
//            arr[i] = i+1;
//        }
//        printArray(arr);
//
//        String arrS[] = new String[5];
//        for(int i=0; i<arr.length; i++){
//            arrS[i] = "abc";
//        }
//        printArray(arrS);

        Vehicle v[] = new Vehicle[5];
        for(int i=0; i< v.length; i++){
            v[i] = new Vehicle(10*i, "ab");
        }
        printArray(v);
    }

}
