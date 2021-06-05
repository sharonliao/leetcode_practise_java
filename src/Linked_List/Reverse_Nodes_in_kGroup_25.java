package Linked_List;

public class Reverse_Nodes_in_kGroup_25 {

    public ListNode reverseList(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode nextTemp = null;
        while(curr != null){
            nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;

    }
    public ListNode reverseKGroup(ListNode head, int k) {

    }

}
