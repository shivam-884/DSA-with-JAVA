package stack;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2){
       if(s1.isEmpty()){
           return;
       }
       int temp = s1.pop();
       reverseStack(s1, s2);
       while (!s1.isEmpty()){
           s2.push(s1.pop());
       }
       s1.push(temp);
       while (!s2.isEmpty()){
           s1.push(s2.pop());
       }

    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 1, 9};
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> helper = new Stack<>();

        for(int elem : arr){
            stack.push(elem);
        }

        reverseStack(stack, helper);

        while (! stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
