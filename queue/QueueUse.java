package queue;

public class QueueUse {
    public static void main(String[] args) throws QueueFullException, QueueEmptyException {
//        QueueUsingArray queue = new QueueUsingArray(4);
//
        int arr[] = {15, 20, 30, 35};

//        for(int elem : arr){
//            queue.enqueue(elem);
//        }
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        queue.enqueue(45);
//        queue.enqueue(55);
//        queue.enqueue(66);
//
//        while(!queue.isEmpty()){
//            System.out.println(queue.dequeue());
//        }

//        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.enqueue(30);
//        queue.enqueue(40);
//        System.out.println(queue.front());
//        System.out.println(queue.size());
//        System.out.println(queue.dequeue());
//        queue.enqueue(50);
//        System.out.println(queue.front());

        QueueUsingLL<Integer> queue = new QueueUsingLL<>();

        for(int elem : arr){
            queue.enqueue(elem);
        }

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(45);
        queue.enqueue(55);
        queue.enqueue(66);

        while(!queue.isEmpty()){
            System.out.print(queue.dequeue() + " ");
        }
    }
}
