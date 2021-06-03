package Linked_List;

public class Swap_Nodes_in_pairs_24 {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode new_head = head.next;
        ListNode temp = head.next.next;
        head.next = temp;
        new_head.next = head;
        ListNode cur = head;

        ListNode first = null;
        ListNode follow = null;

        while (cur.next != null && cur.next.next != null){
            first = cur.next;
            follow = cur.next.next;
            temp = follow.next;
            follow.next = first;
            first.next = temp;
            cur.next = follow;
            cur = first;
        }
        return new_head;
    }
}



