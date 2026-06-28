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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Queue<ListNode> que = new PriorityQueue<>((a, b) -> {return a.val - b.val;});

        for (ListNode list : lists) {
            que.offer(list);
        }

        ListNode dummyNode = new ListNode();
        ListNode curr = dummyNode;
        while (!que.isEmpty()) {
            curr.next = que.poll();
            if ( curr.next.next != null) {
                que.offer(curr.next.next) ;
            }
            curr = curr.next;
        }

        return dummyNode.next;

    }
}
