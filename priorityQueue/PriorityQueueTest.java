package priorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) throws PriorityQueueException {
            /* #### MIN HEAP  #### */
//        Priority_Queue<String> pq = new Priority_Queue<>();
//        pq.insert("abc", 15);
//        pq.insert("def", 13);
//        pq.insert("ghi", 90);
//        pq.insert("jkl", 150);
//        pq.insert("mno", 120);

        /* #### MAX HEAP  #### */
        PriorityQueue2<String> pq2 = new PriorityQueue2<>();
        pq2.insert("abc", 15);
        pq2.insert("def", 13);
        pq2.insert("ghi", 90);
        pq2.insert("jkl", 150);
        pq2.insert("mno", 120);


        while (!pq2.isEmpty()){
            System.out.println(pq2.getMax());
            pq2.removeMax();
        }
    }
}
