package Linked_List;

public class Reverse_Nodes_in_kGroup_25 {

    public Pair<ListNode, ListNode> reverseList(ListNode head, int k) {

        boolean result = checkKNode(head,k);
        System.out.println("check result:"+ result);
        if (!result){
           ListNode tail = new ListNode(0);
           tail.next = null;
           // if less than k node, then return the tail with null next.
           Pair<ListNode, ListNode> pair = new Pair<>(head, tail);
           return pair;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode nextTemp = null;
        int count = 0;
        while(count<k){
            count ++;
            nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        //s
        head.next = nextTemp;
        System.out.println("prev:"+prev.val);

        Pair<ListNode, ListNode> pair = new Pair<>(prev, head);
        return pair;
    }

    public boolean checkKNode(ListNode head, int k){
        int count = 0;
        ListNode curNode = head;
        while (count<k && curNode != null){
            ++ count;
            curNode = curNode.next;
        }
        System.out.println("count:"+count);
        if(count<k)
            return false;
        else
            return true;
    }

    class Pair<T, U> {
        public  T head;
        public  U tail;

        public Pair(T head, U tail) {
            this.head= head;
            this.tail= tail;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        Pair<ListNode, ListNode> pair = reverseList(head,k);
        ListNode new_head = pair.head;
        ListNode k_tail = pair.tail;
        while (k_tail.next != null){

            pair = reverseList(k_tail.next,k);
            ListNode r_head = pair.head;
            ListNode r_tail = pair.tail;
            k_tail.next = r_head;
            k_tail = r_tail;
        }
        return new_head;
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



    public ListNode reverseLinkedList(ListNode head, int k) {

        // Reverse k nodes of the given linked list.
        // This function assumes that the list contains
        // atleast k nodes.
        ListNode new_head = null;
        ListNode ptr = head;

        while (k > 0) {

            // Keep track of the next node to process in the
            // original list
            ListNode next_node = ptr.next;

            // Insert the node pointed to by "ptr"
            // at the beginning of the reversed list
            ptr.next = new_head;
            new_head = ptr;

            // Move on to the next node
            ptr = next_node;

            // Decrement the count of nodes to be reversed by 1
            k--;
        }


        // Return the head of the reversed list
        return new_head;

    }

    public ListNode reverseKGroup_recursive(ListNode head, int k) {

        int count = 0;
        ListNode ptr = head;

        // First, see if there are at least k nodes left in the linked list.
        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }


        // If we have k nodes, then we reverse them
        if (count == k) {

            // Reverse the first k nodes of the list and
            // get the reversed list's head.
            ListNode reversedHead = this.reverseLinkedList(head, k);

            // Now recurse on the remaining linked list. Since
            // our recursion returns the head of the overall processed
            // list, we use that and the "original" head of the "k" nodes
            // to re-wire the connections.
            head.next = this.reverseKGroup(ptr, k);
            return reversedHead;
        }

        return head;
    }



    public static void main(String[] args){
        Reverse_Nodes_in_kGroup_25 test = new Reverse_Nodes_in_kGroup_25();
        ListNode head = test.createAList(1);
        System.out.println("input: "+ test.listToString(head));
        ListNode new_head = test.reverseKGroup(head,2);
        System.out.println("result: "+ test.listToString(new_head));
    }
}
