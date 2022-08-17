package stack;

import java.util.Stack;

public class StackCollections {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        int arr[] = {5,6,7,1,9};

        for(int elem : arr){
            stack.push(elem);
        }

        while (! stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }


//        stack.push(5);
//        System.out.println(stack.size());
//        System.out.println(stack.peek());
//        stack.push(3);
//        stack.push(9);
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.pop());
    }
}
