package stack_queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_a_Stream_703 {

    PriorityQueue<Integer> pQueue;
    int k;

    public Kth_Largest_Element_in_a_Stream_703(int k, int[] nums) {
        pQueue = new PriorityQueue<Integer>(k);
        this.k = k;
        for(int i : nums ){
            //this queue with limited size, so if queue is full, add more elements into it, may replace the element in the queue,
            // PriorityQueue<k> keep the top k elements
            add(i);
        }
        System.out.println(pQueue.toString());
    }

    public int add(int val) {
        if(pQueue.size()<k){
            pQueue.offer(val);
        }else if(pQueue.peek()<val){
            // the kth is smaller than val, then replace it with val
            pQueue.poll();
            pQueue.offer(val);
        }
        return pQueue.peek();
    }
}
