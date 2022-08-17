package queue;

import java.util.Queue;
import java.util.LinkedList;

public class QueueCollection {

    public static void main(String args[]){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(10);
        queue.add(20);
        System.out.println(queue.size());
        queue.add(30);
        System.out.println(queue.peek());
        System.out.println(queue.poll());  // delete the element of front and return
        System.out.println(queue.size());
    }
}
