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
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Compparator());
        
        ListNode root;
        ListNode nodeTemp;
        
        for(ListNode node : lists) {
            if(node != null) heap.add(node);
        }
        if(heap.isEmpty()) return null;
        nodeTemp = heap.poll();
        root = new ListNode(nodeTemp.val);
        ListNode result = root;    
        if(nodeTemp.next != null) heap.add(nodeTemp.next);
        
        while(!heap.isEmpty()) {
            nodeTemp = heap.poll();
            result.next = new ListNode(nodeTemp.val);
            result = result.next;
            
            if(nodeTemp.next != null) heap.add(nodeTemp.next);
        }
        return root;
    }
    
    
    static class Compparator implements Comparator<ListNode> {
        public int compare(ListNode node1, ListNode node2) {
            return node1.val-node2.val;
        }
        
    }
}
