/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // build dummy node
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        // slow, fast pointer:
            // fast pointer move by n + 1 step ahead
            // slow and fast ponter move 1 step/time
            // if fast pointer is null, slow ponter is at n - 1 node
        
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next =  slow.next.next;
        // return dummy.next
         return dummyNode.next;
    }
}
