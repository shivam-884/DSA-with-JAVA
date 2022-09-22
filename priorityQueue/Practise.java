package priorityQueue;


import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Practise {

    // This downHeapify is for building Max heap
    public static void downHeapify(int[] arr, int i, int n){
        int parentIndex = i;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;

        while(leftChildIndex < n){
            int midIndex = parentIndex;

            if(arr[leftChildIndex] > arr[midIndex]){
                midIndex = leftChildIndex;
            }
            if(rightChildIndex < n && arr[rightChildIndex] > arr[midIndex]){
                midIndex = rightChildIndex;
            }
            if(midIndex == parentIndex){
                break;
            }
            int temp = arr[midIndex];
            arr[midIndex] = arr[parentIndex];
            arr[parentIndex] = temp;

            parentIndex = midIndex;
            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;
        }
    }

    public static ArrayList<Integer> kLargest(int input[], int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            pq.add(input[i]);
        }
        for(int i=k; i<input.length; i++){
            if(input[i] > pq.peek()){
                pq.poll();
                pq.add(input[i]);
            }
        }
        while (!pq.isEmpty()){
            arr.add(pq.poll());

        }
        return arr;
    }

    public static boolean helper(int[] arr, int parentIN, int leftIN, int rightIN){
        if(leftIN >= arr.length){
            return true;
        }
        if(arr[parentIN] < arr[leftIN]){
            return false;
        }
        if(rightIN >= arr.length){
            return true;
        }
        if(arr[parentIN] < arr[rightIN]){
            return false;
        }
        boolean leftAns = helper(arr,leftIN,2*leftIN+1,2*leftIN+2);
        boolean rightAns = helper(arr,rightIN,2*rightIN+1,2*rightIN+2);
        return (leftAns && rightAns);
    }
    public static boolean checkMaxHeap(int arr[]) {
        return helper(arr,0,1,2);
    }

    public static int kthLargest(int n, int[] input, int k) {
        for(int i=n/2-1; i>=0; i--){
            downHeapify(input,i,n);
        }
        int ans = Integer.MIN_VALUE;
        for(int i=n-1; i>=n-k; i--){
            ans = input[0];
            int temp = input[i];
            input[i] = input[0];
            input[0] = temp;
            downHeapify(input,0,i);
        }
        return ans;
    }

    public static int buyTicket(int[] input, int k) {
        int n = input.length;
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            pq.add(input[i]);
            q.add(i);
        }
        int time = 0;
        while(!q.isEmpty()){
            int front = q.poll();
            if(input[front] >= pq.peek()){
                pq.remove();
                time++;
                if(front == k){
                    break;
                }
            }else{
                q.add(front);
            }
        }
        return time;
    }
    public static void main(String[] args) {

//        int[] input = {5,2,9,6,8,7,4,11,1,10,3};
//        ArrayList<Integer> arr = kLargest(input,4);
//        for(int a : arr){
//            System.out.print(a + " ");
//        }

//        int[] arr = {42,20,18,6,14,11,9,4};
//        System.out.println(checkMaxHeap(arr));

        int[] arr = {2,3,2,2,4};
        System.out.println(buyTicket(arr,3));
    }
}
