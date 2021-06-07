package stack_queue;

import java.util.Stack;

public class Implement_Queue_using_Stacks_232 {

    Stack<Integer> push_stack;
    Stack<Integer> poll_stack;

    public Implement_Queue_using_Stacks_232() {
        push_stack = new Stack();
        poll_stack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        push_stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Integer element = null;
        if (poll_stack.empty()){
            if(push_stack.empty()){
                return element;
            }else {
                while (!push_stack.empty()){
                    element = push_stack.pop();
                    poll_stack.push(element);
                }
                return poll_stack.pop();
            }
        } else {
            return poll_stack.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        Integer element = null;
        if (poll_stack.empty()){
            if(push_stack.empty()){
                return element;
            }else {
                while (!push_stack.empty()){
                    element = push_stack.pop();
                    poll_stack.push(element);
                }
                return poll_stack.peek();
            }
        } else {
            return poll_stack.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(poll_stack.empty()&&push_stack.empty()){
            return true;
        } else {
            return false;
        }
    }
}
