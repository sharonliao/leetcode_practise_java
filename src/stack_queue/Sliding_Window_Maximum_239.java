package stack_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Sliding_Window_Maximum_239 {
    //
    PriorityQueue<Integer> p_window;
    public int[] Sliding_Window_Maximum_239(int[] nums, int k) {
        p_window = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i<k; i++){
            p_window.add(nums[i]);
        }

        int[] results = new int[nums.length-k+1];
        //the  slide window starts from k
        for(int i = k; i< nums.length; i++){
            //1. get the largest element
            //2.remove the earliest one element
            //3.the window move forward one element.
            results[i-k] = p_window.peek();
            // the index of the earliest one element  i - k
            p_window.remove(nums[i-k]);
            p_window.add(nums[i]);
        }
        results[nums.length-k] = p_window.peek();
        return results;
    }
}
