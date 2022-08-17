package stack;

public class StackUsingArray {

    private int[] data;
    private int topIndex;   // Index of topmost element of stack

    public StackUsingArray(){
        data = new int[2];
        topIndex = -1;
    }

    public StackUsingArray(int size){
        data = new int[size];
        topIndex = -1;
    }

    public int size(){
        return topIndex + 1;
    }

    public boolean isEmpty(){
//        if(topIndex == -1){
//            return true;
//        }else{
//            return false;
//        }

        return topIndex == -1;
    }

    public void push(int elem) throws StackFullException {
        // If stack is full
        if(topIndex == data.length-1){
            // Throw Exception
//            StackFullException e = new StackFullException();
//            throw e;
//            throw new StackFullException();
            doubleCapacity();
        }
       // topIndex++;
        data[++topIndex] = elem;
    }

    private void doubleCapacity(){
        int temp[] = data;
        data = new int[temp.length*2];
        for(int i=0; i<temp.length; i++){
            data[i] = temp[i];
        }
    }

    public int top() throws StackEmptyException {
        if(topIndex == -1){
            // Throw StackEmptyException
            throw new StackEmptyException();
        }
        return data[topIndex];
    }

    public int pop() throws StackEmptyException {
        if(topIndex == -1){
            // Throw StackEmptyException
            throw new StackEmptyException();
        }
        int temp = data[topIndex];
        topIndex--;
        return temp;
    }
}
