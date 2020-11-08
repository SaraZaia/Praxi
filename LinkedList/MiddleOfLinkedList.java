//https://leetcode.com/problems/middle-of-the-linked-list/

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
class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode node = head;
        while(node != null) {
            count++;
            node = node.next;
        }
        int mid = count / 2;
        
        count = 0;
        node = head;
        while(count < mid) {
            count++;
            node = node.next;
        }
        return node;
        
    }
}
