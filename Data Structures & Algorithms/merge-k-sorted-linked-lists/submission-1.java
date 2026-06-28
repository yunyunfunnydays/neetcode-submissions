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
             ListNode minNode = que.poll();
             curr.next = minNode;
            if (minNode.next != null) {
                que.offer(minNode.next) ;
            }
            curr = curr.next;
        }

        return dummyNode.next;

    }
}
