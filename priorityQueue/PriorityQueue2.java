package priorityQueue;
import java.util.ArrayList;
                           /*   ####################   MAX HEAP  #######################*/

public class PriorityQueue2<T> {

    ArrayList<Element<T>> heap;

    public PriorityQueue2(){
        heap = new ArrayList<>();
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here
        return heap.size() == 0;
    }

    int getSize() {
        // Implement the getSize() function here
        return heap.size();
    }

    T getMax() throws PriorityQueueException {
        // Implement the getMax() function here
        if(heap.size() == 0){
            throw new PriorityQueueException();
        }
        return heap.get(0).value;
    }

    void insert(T value, int priority) {
        // Implement the insert() function here
        Element<T> e = new Element<>(value, priority);
        if(heap.size()==0){
            heap.add(e);
            return;
        }

        heap.add(e);

        int childIndex = heap.size()-1;
        int parentIndex = (childIndex - 1)/2;

        while(heap.get(childIndex).priority > heap.get(parentIndex).priority){
            Element<T> temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(childIndex));
            heap.set(childIndex, temp);

            childIndex = parentIndex;
            parentIndex = (childIndex - 1)/2;
        }
    }

    T removeMax() throws PriorityQueueException {
        // Implement the removeMax() function here
        if(heap.size() == 0){
            throw new PriorityQueueException();
        }
        Element<T> removed = heap.get(0);
        T ans = removed.value;
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;

        while(leftChildIndex < heap.size()){
            int minIndex = parentIndex;

            if(heap.get(leftChildIndex).priority > heap.get(minIndex).priority){
                minIndex = leftChildIndex;
            }

            if(rightChildIndex < heap.size() && heap.get(rightChildIndex).priority > heap.get(minIndex).priority){
                minIndex = rightChildIndex;
            }

            if(minIndex == parentIndex){
                break;
            }

            Element<T> temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(minIndex));
            heap.set(minIndex, temp);
            parentIndex = minIndex;
            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;
        }
        return ans;
    }

}
