package stack;

public class StackUse {

    public static void main(String[] args) throws StackEmptyException, StackFullException {
//        StackUsingArray stack = new StackUsingArray();
//        int[] arr = {5,6,7,1,9};
//
//        for(int i=0; i<arr.length; i++){
//            stack.push(arr[i]);
//        }
//
//        while(!stack.isEmpty()){
//            System.out.print(stack.pop() + " ");
//        }

//        stack.push(10);
//        System.out.println(stack.top());
//        stack.pop();
//        stack.size();
//        System.out.println(stack.isEmpty());
//        stack.pop();

        StackUsingLL<Integer> stack = new StackUsingLL<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        stack.push(40);
        System.out.println(stack.size());
        stack.push(50);
        System.out.println(stack.top());

    }
}
