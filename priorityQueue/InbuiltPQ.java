package priorityQueue;

import java.util.PriorityQueue;

public class InbuiltPQ {

    public static void main(String[] args) {
        int[] arr = {4,3,7,6,9,10,1,2};

        // Inbuilt priority queue is min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : arr){
            pq.add(a);
        }
       // System.out.println(pq.peek());

        while (!pq.isEmpty()){
            System.out.print(pq.peek() + " ");
            pq.poll();
        }
    }
}
