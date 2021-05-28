class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


public class Reverse_Linked_List_206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

//        ListNode pre = head;
//        ListNode temp_next = pre.next;
//        ListNode follow = null;
//        while(temp_next != null){
//            follow = temp_next;
//            temp_next = follow.next;
//            //sawp pre node and follow node
//            follow.next = pre;
//            //move to next node
//            pre = follow;
//        }
//        head.next = null;
//        return follow;

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

    public ListNode createAList(int length){
        ListNode head = new ListNode(0);
        ListNode pre = head;
        for(int i  = 1; i< length; i++){
            ListNode next = new ListNode(i);
            pre.next = next;
            pre = next;
        }
        return head;
    }

    public String listToString(ListNode head){
        String result = "";
        if(head == null){
            return result;
        }
        ListNode curNode = head;
        while(curNode.next != null){
            result += curNode.val;
            curNode = curNode.next;
        }
        result += curNode.val;
        return result;
    }

    public static void main(String[] args){
        Reverse_Linked_List_206 test = new Reverse_Linked_List_206();
        ListNode head = test.createAList(10);
        System.out.println("input: "+ test.listToString(head));
        ListNode new_head = test.reverseList(head);
        System.out.println("result: "+ test.listToString(new_head));

    }


}