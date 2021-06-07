package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_using_Queues_225 {
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

    /** Initialize your data structure here. */

    Queue<Integer> curQ ;
    Queue<Integer> backupQ ;
    public Implement_Stack_using_Queues_225() {
        curQ = new LinkedList<>();
        backupQ = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        curQ.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Integer element = null;
        while (!curQ.isEmpty()){
            element = curQ.poll();
            // the last one element was polled from the current queue, not wasn't put into backup queue.
            if(!curQ.isEmpty()){
                backupQ.add(element);
            }else {
                Queue<Integer> tempQ= curQ;
                curQ = backupQ;
                backupQ = tempQ;
                return element;
            }
        }
        return element;
    }

    /** Get the top element. */
    public int top() {
        Integer element = null;
        while (!curQ.isEmpty()){
            element = curQ.poll();
            backupQ.add(element);
        }
        Queue<Integer> tempQ= curQ;
        curQ = backupQ;
        backupQ = tempQ;
        return element;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(curQ.isEmpty() && backupQ.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
