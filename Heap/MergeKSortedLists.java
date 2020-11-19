//https://leetcode.com/problems/merge-k-sorted-lists/

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
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                // Intentional: Reverse order for this demo
                return o1.val-o2.val;
            }
        });

        for(ListNode node : lists) {
            if(node != null) pQueue.add(node);
        }
        
        ListNode result = new ListNode(0);
        ListNode curr = result;
        ListNode min;
        while(!pQueue.isEmpty()) {
            min = pQueue.poll();
            if(min.next != null) pQueue.add(min.next);
            curr.next = min;
            curr = curr.next;
        }
        
        return result.next;
    }


}

