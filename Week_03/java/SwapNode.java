public class SwapNode {
    /**
     * Definition for singly-linked list.
     */
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode curNode = preHead;
        while(curNode.next!=null&&curNode.next.next!=null){
            ListNode first = curNode.next;
            ListNode second = first.next;

            curNode.next = second;
            first.next =second.next;
            second.next = first;


            curNode = first;
        }
        return preHead.next;
    }


}
