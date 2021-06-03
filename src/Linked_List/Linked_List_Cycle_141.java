package Linked_List;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class Linked_List_Cycle_141 {


    HashSet<ListNode> nextSet = new HashSet<>();
    public boolean hasCycle_set(ListNode head) {
        ListNode curr = head;
        while (curr != null){
            if(nextSet.contains(curr)){
                return true;
            }else {
                nextSet.add(curr);
                curr = curr.next;
            }
        }
        return false;
    }


    public boolean hasCycle_towPoint(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != slow){
            if(fast == null || fast.next == null){
                // if there is a cycle in the list, then the fast node must reaching the null fist.
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }



}
