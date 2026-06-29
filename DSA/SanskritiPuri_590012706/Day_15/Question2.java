/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next; // Store next node
            current.next = prev;              // Reverse the link
            prev = current;                   // Move prev forward
            current = nextNode;               // Move current forward
        }

        return prev; // New head of reversed list
    }
}
