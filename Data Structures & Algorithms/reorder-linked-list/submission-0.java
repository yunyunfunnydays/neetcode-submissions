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

//  [1,2,3,4,5] [1,5,2,4,3]

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // find mid by fast and slow node
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse List: from middle to end
        
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // build new list
        ListNode headL = head;
        ListNode headR = prev;

        while (headR != null) {
            ListNode tempL = headL.next;
            ListNode tempR = headR.next;
            headL.next = headR;
            headR.next = tempL;

            headL = tempL;
            headR = tempR;
        }
    }
}
