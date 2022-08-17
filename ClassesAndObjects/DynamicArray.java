package ClassesAndObjects;

public class DynamicArray {

    private int data[];
    private int nextElementIndex;

    public DynamicArray(){
        data = new int[5];
        nextElementIndex = 0;
    }

    public int size(){
        return nextElementIndex;
    }

    public boolean isEmpty(){
        return nextElementIndex == 0;
    }

    public int get(int i){
        if(i >= nextElementIndex){
            // Throw Error
            return -1;
        }
        return data[i];
    }

    public void set(int index, int element){
        if(index >= nextElementIndex){
            // Throw Error
            return;
        }
        data[index] = element;
    }

    public void add(int element){

        if(nextElementIndex == data.length){  // This means array is full, it has no space
            doubleCapacity(); // So now, We have to double the size of array
        }
        data[nextElementIndex] = element;
        nextElementIndex++;
    }

    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2 * temp.length];
        for(int i = 0; i< temp.length; i++){
            data[i] = temp[i];
        }
    }

    public int removeLast(){
        if(nextElementIndex == 0){
            return -1;
        }
        int temp = data[nextElementIndex - 1];
        data[nextElementIndex - 1] = 0;
        nextElementIndex--;
        return temp;

    }

}


