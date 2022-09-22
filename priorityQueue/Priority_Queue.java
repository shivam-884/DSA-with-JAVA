package priorityQueue;

import java.util.ArrayList;

                          /* ####################     MIN HEAP     #####################*/
public class Priority_Queue<T> {
    private ArrayList<Element<T>> heap;

    public Priority_Queue(){
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority){
        Element<T> e = new Element<>(value, priority);
        heap.add(e);
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0) {
            if (heap.get(childIndex).priority < heap.get(parentIndex).priority) {
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }else{
                return;
            }
        }
    }

    public T getMin() throws PriorityQueueException {
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        return heap.get(0).value;
    }

    public T removeMin() throws PriorityQueueException {
        if(heap.isEmpty()){
            throw new PriorityQueueException();
        }
//        Element<T> lastLeaf = heap.remove(heap.size()-1);
//        if(heap.isEmpty()){
//            return lastLeaf.value;
//        }
//        Element<T> temp = heap.get(0);
//        heap.set(0,lastLeaf);
//
//        int parentIndex = 0;
//        int childIndex1 = 2 * parentIndex + 1;
//        int childIndex2 = 2 * parentIndex + 2;
//        int leastPriority = 0;
//
//        while (childIndex1 < heap.size()-1 && childIndex2 < heap.size()-1) {
//            if (heap.get(childIndex1).priority < heap.get(childIndex2).priority) {
//                leastPriority = childIndex1;
//            } else {
//                leastPriority = childIndex2;
//            }
//            Element<T> temp2 = heap.get(leastPriority);
//            heap.set(leastPriority, heap.get(parentIndex));
//            heap.set(parentIndex, temp2);
//            parentIndex = leastPriority;
//            childIndex1 = 2 * parentIndex + 1;
//            childIndex2 = 2 * parentIndex + 2;
//        }
//        return temp.value;

        Element<T> removed = heap.get(0);
        T ans = removed.value;

        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;

        while (leftChildIndex < heap.size()) {
            int minIndex = parentIndex;
            if (heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = rightChildIndex;
            }

            if(minIndex == parentIndex){
                break;
            }

            Element<T> temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            parentIndex = minIndex;
            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;
        }
        return ans;
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        return heap.size() == 0;
    }

}
