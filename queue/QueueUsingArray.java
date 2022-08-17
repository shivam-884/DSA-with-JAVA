package queue;

public class QueueUsingArray {

    private int data[];
    private int front; // Index of the element at the front of the queue
    private int rear; // Index of the element at the rear of the queue
    private int size;

    public QueueUsingArray(){
        data = new int[5];
        front = -1;
        rear = -1;
    }

    public QueueUsingArray(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2* temp.length];
        int index = 0;
        for(int i=front; i<temp.length; i++){
            data[index++] = temp[i];
        }
        for(int i=0; i<front; i++){
            data[index++] = temp[i];
        }
        front = 0;
        rear = temp.length - 1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int elem) throws QueueFullException {
        if(size == data.length){
          //  throw new QueueFullException();
            doubleCapacity();
        }

        if(size == 0){
            front = 0;
        }

        // When we delete any element from front then size will be decrease and previous front will be empty then at that space
        // we refer rear and insertion take place there until the size of queue full.

//        rear++;
//        if(rear == data.length){
//            rear = 0;
//        }
        // OR
        rear = (rear+1)% data.length;
        data[rear] = elem;
        size++;

    }

    public int front() throws QueueEmptyException {
        if(size == 0){
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public int dequeue() throws QueueEmptyException {
        if(size == 0){
            throw new QueueEmptyException();
        }
        int temp = data[front];

        // When we delete any element from front then size will be decrease and  like this when we reach at the last index of queue
        //  and we want to insert one element at that time front will refer to 0 index.

//        front++;
//        if(front == data.length){
//            front = 0;
//        }

        // OR

        front = (front+1)% data.length;
        size--;
        if(size == 0){
            front = -1;
            rear = -1;
        }
        return temp;
    }
}
