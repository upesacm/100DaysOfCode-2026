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

//Need to merge two sorted linked lists into one sorted list

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {

            // just pick the smaller node each time
            if (list1.val <= list2.val) {

                curr.next = list1;
                list1 = list1.next;

            } else {

                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        // one list might still have some nodes left
        if (list1 != null) {

            curr.next = list1;

        } else {

            curr.next = list2;
        }

        return dummy.next;
    }
}