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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode curr = null;
        
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if ( curr1.val <= curr2.val) {
            curr = curr1;
            curr1 = curr1.next;
        } else {
            curr = curr2;
            curr2 = curr2.next;
        }
        ListNode result = curr;

        while ( curr1 != null && curr2 != null) {
            // curr1 <= curr2 

                // add curr1 to result
                // curr1 move to next node
                
            // else ...
            if (curr1.val <= curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
                curr = curr.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
                curr = curr.next;
            }
        }
        // add remain node to tail
        if(curr1 != null){
            curr.next = curr1;
        }else{
            curr.next = curr2;
        }
        // return result
        return result;
    }
}