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
    public boolean hasCycle(ListNode head) {
        // Edge case check
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // move fast by 2 step
            // move slow by 1 step
            slow = slow.next;
            fast = fast.next.next;
            
            // if two node are the same -> return true
            if (fast == slow) return true;
        }
        // return false;
        return false;
    }
}
 